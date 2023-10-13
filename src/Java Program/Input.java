/*
September 20th 2020
 * This is GUI class. This frame allow user to enter the amount of food made and food left of a specific dish. 
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class Input extends JFrame implements ActionListener
{

    //Color
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color SLIVER = new Color(192, 192, 192);
    //Menu bar
    private JMenuBar mainBar;
    private JMenu moreMenu;
    private JMenuItem helpMenu;
    //JButton
    private JButton closeButton;
    private JButton inputButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
    //JComboBox
    private JComboBox dishType;
    //option for JComboBox
    private String[] dishTypeOption =
    {
        "Entree", "Salad", "Desert", "Fruit", "Drink"
    };

    //JLabel
    private JLabel dishIDLabel;
    private JLabel madeLabel;
    private JLabel LeftoverLabel;
    //JTextField
    private JTextField madeTextField;
    private JTextField leftoverTextField;
    private JTextField dishIDTextField;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();
    //JTable
    private JTable entreeTable;
    private JTable fruitTable;
    private JTable saladTable;
    private JTable desertTable;
    private JTable drinkTable;
    //Data for JTable
    private Object[][] dataTable;
    //Inputting variable 
    private double foodMade;
    private double foodLeft;
    private double ratio;
    private int dishID;

    //Constructor 
    public Input()
    {
        //Frame size 
        super("Input Ratio");
        this.setBounds(500, 100, 900, 700);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Menu bar 
        this.mainBar = new JMenuBar();
        mainBar.setBackground(GRAY);
        this.moreMenu = new JMenu("More");
        this.helpMenu = new JMenuItem("Help");
        helpMenu.addActionListener(this);
        moreMenu.add(helpMenu);
        mainBar.add(moreMenu);
        this.setJMenuBar(mainBar);
        //Panel
        //center Panel 
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        //Left Panel
        this.westPanel = new JPanel(new GridBagLayout());
        westPanel.setBackground(GRAY);
        this.add(westPanel, BorderLayout.WEST);
        //top Panel
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        //Bottom Panel 
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        //this.westPanel = new JPanel(new GridBagLayout());
        //Bottom panel
        //add close Button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 50, 20, 50);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);

        //Central Panel
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.dishType = new JComboBox(dishTypeOption);
        dishType.addActionListener(this);
        westPanel.add(dishType, gbc);
        //Decalring label and textfield
        //"Food Made" Label
        this.madeLabel = new JLabel("Food Made (kg)");
        //"Food Left" Label
        this.LeftoverLabel = new JLabel("Food Left (kg)");
        //TextField for food left over 
        this.leftoverTextField = new JTextField(5);
        //TextField for food made 
        this.madeTextField = new JTextField(5);
        //Input Button
        this.inputButton = new JButton("Input");
        inputButton.addActionListener(this);
        //"Dish ID" Label
        this.dishIDLabel = new JLabel("Dish ID");
        //TextField for Dish ID  
        this.dishIDTextField = new JTextField(6);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //Database Connection
        String dbName = "CUISINES";
        JavaDatabase objDb = new JavaDatabase(dbName);
        Connection myDbConn = null;
        myDbConn = objDb.getDbConn();
        //Close the frame
        if (command.equals("Close"))
        {
            this.dispose();
        } //Opening help frame 
        else if (command.equals("Help"))
        {
            this.dispose();
            Help objHelp = new Help();
        } //user selection in JComboBox
        else if (e.getSource() == dishType)
        {
            JComboBox cb = (JComboBox) e.getSource();
            //get user selection
            String dishType = (String) cb.getSelectedItem();
            //columns for JTable
            String[] column =
            {
                "Dish ID", "Dish Name", "Type", " Ingredient", "Sauce "
            };
            //if "entree" option is slected 
            if (dishType.equals("Entree"))
            {
                try
                {
                    //remove pre-existing table
                    centerPanel.removeAll();
                    //set target table
                    String targetTable = "Entree";
                    //set data and get data
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.entreeTable = new JTable(dataTable, column);
                    //add jTable to Panel
                    this.centerPanel.add(new JScrollPane(entreeTable), gbc);
                    //add TextFields and Labels
                    addInputTextField();
                } catch (Exception exceptionObj)
                {
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }
            } //if "salad" option is slected 
            else if (dishType.equals("Salad"))
            {
                try
                {
                    //remove pre-existing table
                    centerPanel.removeAll();
                    //set target table
                    String targetTable = "Salad";
                    //set data and get data
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //Maje jTabel
                    this.saladTable = new JTable(dataTable, column);
                    //add jTable to Panel
                    this.centerPanel.add(new JScrollPane(saladTable), gbc);
                    //reset Textfields and Labels
                    addInputTextField();
                } catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }
            } //if "desert" option is slected 
            else if (dishType.equals("Desert"))
            {
                try
                {
                    //remove pre-existing table
                    centerPanel.removeAll();
                    //set target table
                    String targetTable = "Desert";
                    //set data and get data
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.desertTable = new JTable(dataTable, column);
                    //add jTable to Panel
                    this.centerPanel.add(new JScrollPane(desertTable), gbc);
                    //reset TextFields and Labels
                    addInputTextField();
                } catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } //if "fruit" option is slected 
            else if (dishType.equals("Fruit"))
            {
                try
                {
                    //remove pre-existing table
                    centerPanel.removeAll();
                    //set target table
                    String targetTable = "Fruit";
                    //set data and get data
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //make JTable
                    this.fruitTable = new JTable(dataTable, column);
                    //add jTable to Panel
                    this.centerPanel.add(new JScrollPane(fruitTable), gbc);
                    //reset TextFields and Labels
                    addInputTextField();
                } catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } //if "drink" option is slected 
            else if (dishType.equals("Drink"))
            {
                try
                {
                    //remove pre-existing table
                    centerPanel.removeAll();
                    //set target table
                    String targetTable = "Drink";
                    //set data and get data
                    DataTable objDataTable = new DataTable(targetTable);
                    objDataTable.setDataTable();
                    dataTable = objDataTable.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    //Make JTable
                    this.drinkTable = new JTable(dataTable, column);
                    //add jTable to Panel
                    this.centerPanel.add(new JScrollPane(drinkTable), gbc);

                    addInputTextField();
                } catch (Exception exceptionObj)
                {
                    //Pop up error frame letting the user know that there is an error in the system
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }
            }
        } //User input data 
        else if (command.equals("Input"))
        {
            try
            {
                //get user Dish ID input
                dishID = Integer.parseInt(dishIDTextField.getText());
                //get user input of amound of food made
                foodMade = Integer.parseInt(madeTextField.getText());
                //get user input of amound of food left over
                foodLeft = Integer.parseInt(leftoverTextField.getText());
                //If the entered inout is logicall ( the amound of food made is bigegr than food left over)
                if (foodMade >= foodLeft)
                {
                    //calculating the ratio from method of CalculateRatio class
                    CalculateRatio objCalRatio = new CalculateRatio(foodMade, foodLeft);
                    objCalRatio.setCalculateRatio();
                    ratio = objCalRatio.getCalculateRatio();
                    
                    //Using query to update the new ratio of the dish 
                    String dbQuery1 = "UPDATE DishRatio SET Ratio = " + ratio
                            + " WHERE DishID = " + dishID;
                    PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                    ps.executeUpdate();
                    //reset textfields and labels 
                    resetTextField();
                    //pop up frame telling user that data has been inputted sucessfully 
                    new SystemMessage("Sucessfully Input");
                } //if the user enter illogical data ( food lef over is more than food made)
                else if (foodMade < foodLeft)
                {
                    //Pop up frame that will remind the user to fix the data inputted
                    UserError objUserError = new UserError("Food left cannot be larger than food made");
                    //reset the textfield
                    resetTextField();
                }
            } 
            //If the user didnot enter a correct format ( not a number for dishID)
            catch (NumberFormatException nfe)
            {
                //Pop up error frame that will remind the user about the error
                UserError errorObj = new UserError("Enter a number please !!");
            }
            catch (SQLException se)
            {
                System.out.println("Error inserting data ( Inputclass )");
                //Pop up error frame letting the user know that there is an error in the system
                SystemError errorObj = new SystemError("System error: There is something in insertting the data, please contact developer.");
            }
        }

        this.validate();
        this.repaint();
    }

    //Main method for testing
    public static void main(String args[])
    {
        Input objInput = new Input();
    }

    //addind Textfield for inputting data
    private void addInputTextField()
    {
        gbc.insets = new Insets(50, 0, 10, 0);
        //add Dish ID Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(dishIDLabel, gbc);
        //add textfield for dish ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        westPanel.add(dishIDTextField, gbc);
        //Add Food Made label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(50, 10, 5, 10);
        westPanel.add(madeLabel, gbc);
        //add textfield for the amount of food made
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 4;
        westPanel.add(madeTextField, gbc);
        //add left over label
        gbc.insets = new Insets(50, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 5;
        westPanel.add(LeftoverLabel, gbc);
        //add textfield for the amount of food left over
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(5, 10, 5, 10);
        westPanel.add(leftoverTextField, gbc);
        //add inout Buttons
        gbc.insets = new Insets(50, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 7;
        westPanel.add(inputButton, gbc);
    }

    //Method to reset the Panel 
    private void resetPanels()
    {
        //remove dish ID Label
        westPanel.remove(dishIDLabel);
        //remove textfield for dish ID
        westPanel.remove(dishIDTextField);
        //remove Food Made label
        westPanel.remove(madeLabel);
        //remove textfield for the amount of food made
        westPanel.remove(madeTextField);
        //remove left over label
        westPanel.remove(LeftoverLabel);
        //remove textfield for the amount of food left over
        westPanel.remove(leftoverTextField);
        //remove inout Buttons
        westPanel.remove(inputButton);
        //remove pre-existing table
        centerPanel.removeAll();
        //reset TextField
        madeTextField.setText("");
        leftoverTextField.setText("");
        dishIDTextField.setText("");
    }

    //method use to reset textField
    private void resetTextField()
    {
        dishIDTextField.setText("");
        madeTextField.setText("");
        leftoverTextField.setText("");

    }
}
