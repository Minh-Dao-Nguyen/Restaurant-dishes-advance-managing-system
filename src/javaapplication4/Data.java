/*
 September 25th, 2020
 * This class is GUI class. This frame allows user to view data in database.
 */
//package internalassesment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Data extends JFrame implements ActionListener
{
    //Color
    public static final Color WHITE = new Color(255,255,255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color SLIVER = new Color(192, 192, 192);
    //Menu bar
    private JMenuBar mainBar;
    private JMenu moreMenu;
    private JMenuItem helpMenu;
    //JButton
    private JButton closeButton;
    private JButton deleteOption;
    private JButton deleteButton;
    private JButton updateOption;
    private JButton reloadButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
    //JLabel
    private JLabel dishIDLabel;
    private JLabel columnNameLabel;
    private JLabel updateLabel;
    //JTextField
    private JTextField dishIDTextField;
    private JTextField columnNameTextField;
    private JTextField updateTextField;
    //table
    private JTable mainTable;
    private JTable entreeTable;
    private JTable ingredientTable;
    private JTable fruitTable;
    private JTable saladTable;
    private JTable sauceTable;
    private JTable desertTable;
    private JTable drinkTable;
    //table option
    private String[] tableName =
    {
        "Main Table", "Entree Table", "Ingredients Table", "Salad Table", "Sauce Table", "Desert Table", "Drink Table"
    };
    private JComboBox tableOption;
    //2d Array 
    private Object[][] dataTable;
    //JLabel
    private JLabel messageLabel;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Contructor
    public Data()
    {
        //Size of the frame
        super("Data");
        this.setBounds(500, 100, 900, 700);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //JLabel
        this.dishIDLabel = new JLabel("Dish ID");
        this.columnNameLabel = new JLabel("Column Name");
        this.updateLabel = new JLabel("Change");
        //Declare Button
        this.deleteOption = new JButton("Delete");
        deleteOption.addActionListener(this);
        this.deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(this);
        this.updateOption = new JButton("Update");
        updateOption.addActionListener(this);
        this.reloadButton = new JButton("Reload Table");
        reloadButton.addActionListener(this);
        //TextField
        this.dishIDTextField = new JTextField(5);
        this.columnNameTextField = new JTextField(5);
        this.updateTextField = new JTextField(5);
        //Menu bar 
        this.mainBar = new JMenuBar();
        mainBar.setBackground(GRAY);
        this.moreMenu = new JMenu("More");
        this.helpMenu = new JMenuItem("Help");
        helpMenu.addActionListener(this);
        moreMenu.add(helpMenu);
        mainBar.add(moreMenu);
        this.setJMenuBar(mainBar);
        //Panels
        //center Panel
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        //Top Panel
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        //Bottom Panel
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        //Left Panel
        this.westPanel = new JPanel(new GridBagLayout());
        westPanel.setBackground(SLIVER);
        this.add(westPanel, BorderLayout.WEST);
        //Bottom panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 50, 20, 50);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);
        //West Panel
        //adding JComboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.tableOption = new JComboBox(tableName);
        tableOption.addActionListener(this);
        westPanel.add(tableOption, gbc);
        //Adding Update Button
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(updateOption, gbc);
        //adding Delete Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(deleteOption, gbc);
        //Adding reload Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        westPanel.add(reloadButton, gbc);
        //Set default table (table that will display when the frame is opened)
        String targetTable = "Main Table";
        DataTable objDataTable = new DataTable(targetTable);
        objDataTable.setDataTable();
        dataTable = objDataTable.getDataTable();
        gbc.gridx = 0;
        gbc.gridy = 0;
        //column for JTable
        String[] column =
        {
            "Dish ID", "Type", "Dish Name", " Ingredient", "Sauce "
        };
        //Making JTable
        this.mainTable = new JTable(dataTable, column);
        //adding JTable to Panel
        this.centerPanel.add(new JScrollPane(mainTable), gbc);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //connect to Database and calling JavaDatabase object 
        JavaDatabase objDB = new JavaDatabase("CUISINES");
        //Closing the frame
        if (command.equals("Close"))
        {
            this.dispose();
        } 
        //Open help frame 
        else if (command.equals("Help"))
        {
            this.dispose();
            Help objHelp = new Help();
        } 
        //Reload the frame
        else if (command.equals("Reload Table"))
        {
            this.dispose();
            new Data();
        }
        // System display table for user when they ask for a data in JCombo Box
        else if (e.getSource() == tableOption)
        {
            JComboBox cb = (JComboBox) e.getSource();
            //getting user selection
            String table = (String) cb.getSelectedItem();
            //Columns for the table
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", " Ingredient", "Sauce "
            };
            //Main Table selected
            if (table.equals("Main Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Main Table";
                    //set and get data for jTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.mainTable = new JTable(dataTable, column);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(mainTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Entree Table selected
            else if (table.equals("Entree Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Entree";
                    //set and get data for jTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.entreeTable = new JTable(dataTable, column);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(entreeTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Ingredient Table selected
            else if (table.equals("Ingredients Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Ingredient";
                    //set and get data for jTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    this.dataTable = objDataTable.getDataTable();
                    //Columns for the table
                    String[] columnIngredient =
                    {
                        "Dish ID", "Dish Name", "Ingredient"
                    };
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.ingredientTable = new JTable(dataTable, columnIngredient);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(ingredientTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Salad table selected
            else if (table.equals("Salad Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Salad";
                    //set and get data for JTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.saladTable = new JTable(dataTable, column);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(saladTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Sauce Table selected
            else if (table.equals("Sauce Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Sauce";
                    //set and get data for JTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //Columns for the table
                    String[] columnSauce =
                    {
                        "Dish ID", "Dish Name", "Sauce"
                    };
                    //make JTable
                    this.sauceTable = new JTable(dataTable, columnSauce);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(sauceTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Desert Table selected
            else if (table.equals("Desert Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Desert";
                    //set and get data for JTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.desertTable = new JTable(dataTable, column);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(desertTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Drink Table selected
            else if (table.equals("Drink Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Drink";
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.drinkTable = new JTable(dataTable, column);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(drinkTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            } //Fruit Table selected
            else if (table.equals("Fruit Table"))
            {
                try
                {
                    //remove pre-existing Table
                    centerPanel.removeAll();
                    //set targeted table
                    String targetTable = "Fruit";
                    //set and get data for JTable
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.fruitTable = new JTable(dataTable, column);
                    //add JTable to Panel
                    this.centerPanel.add(new JScrollPane(fruitTable), gbc);
                } 
                //If there are any error in system or in making the data for the table process
                catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
                }

            }

        } //Funcnality of delete 
        else if (command.equals("Delete"))
        {
            gbc.insets = new Insets(10, 50, 10, 50);
            //remove Upfate Button
            westPanel.remove(updateOption);
            //remove Delete Button
            westPanel.remove(deleteOption);
            //remove Reload Button
            westPanel.remove(reloadButton);
            //add "Dish ID" Label for text Field
            gbc.gridx = 0;
            gbc.gridy = 1;
            westPanel.add(dishIDLabel, gbc);
            //add TextField under the Label
            gbc.gridx = 0;
            gbc.gridy = 2;
            westPanel.add(dishIDTextField, gbc);
            //add Delete Button
            gbc.gridx = 0;
            gbc.gridy = 3;
            westPanel.add(deleteButton, gbc);
        } //Funcnality of Update 
        else if (command.equals("Update"))
        {
            //pop up update frame for user to input
            UpdateFrame objUpdate = new UpdateFrame();

        } 
        //Delete data in database
        else if (command.equals("DELETE"))
        {
            try
            {
                //get dishID input by the user 
                int dishID = Integer.parseInt(dishIDTextField.getText());
                //delete the row using delete method in JavaDatabase class
                objDB.delete(dishID);
                //pop up frame telling user that the input is sucesfull
                SystemMessage objMessage = new SystemMessage("Sucessfully delete");
                //reset the frame
                reset();

            } 
            // Detection if the user has not inpout anything into the textfield or enter different than a number
            catch (NumberFormatException nfe)
            {
                //Pop up error frame that will remind the user about the error
                UserError errorObj = new UserError("Enter a number please !!");
            }
            //If there are any error in system or in making the data for the table process
            catch (Exception exceptionObj)
            {
                //Pop up error frame letting the user know that there is an error in the system
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }

        }
        this.validate();
        this.repaint();
    }

    //Reset after the user press Delete method
    private void reset()
    {
        //remove "Dish ID" Label for text Field
        westPanel.remove(dishIDLabel);
        //remove TextField under the Label
        westPanel.remove(dishIDTextField);
        //remove Delete Button
        westPanel.remove(deleteButton);
        //add update Button back
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(updateOption, gbc);
        //add delete Button back
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(deleteOption, gbc);
        //add reload button back
        gbc.gridx = 0;
        gbc.gridy = 3;
        westPanel.add(reloadButton, gbc);
    }
    //Main method for testing
    public static void main(String args[])
    {
        Data objData = new Data();
    }

}
