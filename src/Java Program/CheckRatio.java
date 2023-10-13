/*
September 25th, 2020
 * This is GUI class. This frame allows user to input a desired ration. Then the program will display 
all dishes that pass that ratio. 
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class CheckRatio extends JFrame implements ActionListener
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
    private JButton backButton;
    private JButton checkButton;
    private JButton closeButton;
    private JButton favoriteButton; //when ratio is 0
    private JButton halfButton; // when ratio is 0.5
    private JButton hateButton; //when ratio is greater than 0.75
    private JButton advanceButton; //for advance checking
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
    //TextField
    private JTextField ratioTextField;
    //JLabel
    private JLabel ratioLabel;
    //JComboBox
    private JComboBox typeBox;
    //Options in JCombo Box
    private String[] typeOption =
    {
        "Main Table", "Entree", "Salad", "Desert", "Sauce", "Fruit", "Drink"
    };
    //User tabel selection
    private String userTableSelection;
    //table
    private JTable displayTable;
    //desired Ratio
    private double checkRatio;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Constructor 
    public CheckRatio()
    {
        //Size of the frame
        super("Ratio");
        this.setBounds(500, 100, 900, 700);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Declare Buttons
        this.advanceButton = new JButton("Advance");
        advanceButton.addActionListener(this);
        this.favoriteButton = new JButton("Favorite");
        favoriteButton.addActionListener(this);
        this.halfButton = new JButton("Half");
        halfButton.addActionListener(this);
        this.hateButton = new JButton("Hate");
        hateButton.addActionListener(this);
        this.checkButton = new JButton("Check");
        checkButton.addActionListener(this);
        this.backButton = new JButton("Back");
        backButton.addActionListener(this);
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
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
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
        gbc.gridx = 1;
        gbc.gridy = 0;

        //Declare Label and textfield
        this.ratioLabel = new JLabel("Ratio");
        this.ratioTextField = new JTextField(5);
        //West Panel
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //declaring JCombobox and add its options
        this.typeBox = new JComboBox(typeOption);
        typeBox.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        //Adding JComboBox to the panel
        westPanel.add(typeBox, gbc);
        gbc.insets = new Insets(30, 10, 30, 10);
        //Add favorite Button
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(favoriteButton, gbc);
        //Add half Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(halfButton, gbc);
        //Add hate Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        westPanel.add(hateButton, gbc);
        //Add advance Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        westPanel.add(advanceButton, gbc);
        //Set default User Selection
        userTableSelection = "Main Table";
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String table = "";
        //Column Table
        String[] columns =
        {
        };
        // Table Data
        Object[][] dataTable;
        //Closing the program
        if (command.equals("Close"))
        {
            this.dispose();
        } //Open help Frame
        else if (command.equals("Help"))
        {
            Help objHelp = new Help();
        } //Get User Selection in JCombo box
        else if (e.getSource() == typeBox)
        {
            //get user selection
            JComboBox cb = (JComboBox) e.getSource();
            String tableInput = (String) cb.getSelectedItem();
            table = tableInput;
            //Main Table selected
            if (table.equals("Main Table"))
            {
                userTableSelection = table;
            } // Entree Table selected
            else if (table.equals("Entree"))
            {
                userTableSelection = table;
            } //Ingredient Table selected
            else if (table.equals("Ingredients"))
            {
                userTableSelection = table;
            } //Salad Table selected
            else if (table.equals("Salad"))
            {
                userTableSelection = table;

            } //Sauce Table selected
            else if (table.equals("Sauce"))
            {
                userTableSelection = table;
            } //Fruit Table selected
            else if (table.equals("Fruit"))
            {
                userTableSelection = table;
            } //Desert Table selected
            else if (table.equals("Desert"))
            {
                userTableSelection = table;
            } //Drink Table selected
            else if (table.equals("Drink"))
            {
                userTableSelection = table;
            }

        } //Show Favorite dishes 
        else if (command.equals("Favorite"))
        {
            //remove pre-existing table 
            centerPanel.removeAll();
            //set target ratio to 0 ( no food left over )
            checkRatio = 0.0;
            CheckRatioTable objSelect = new CheckRatioTable();
            //Set target table
            objSelect.setTargetTable(userTableSelection);
            //Set ratio
            objSelect.setCheckRatio(checkRatio);
            //Set and get data
            objSelect.setData();
            dataTable = objSelect.getDataTable();
            gbc.gridx = 0;
            gbc.gridy = 0;
            //Indetify suitable columns for table
            columns = identifyColumn();
            //Make Table
            this.displayTable = new JTable(dataTable, columns);
            //Add Table to Panel
            this.centerPanel.add(new JScrollPane(displayTable), gbc);
        } //Show dish that half was eaten 
        else if (command.equals("Half"))
        {
            //remove pre-existing table 
            centerPanel.removeAll();
            //set target ratio to 0.5 ( half food left over )
            checkRatio = 0.5;
            CheckRatioTable objSelect = new CheckRatioTable();
            //Set target table
            objSelect.setTargetTable(userTableSelection);
            //Set ratio
            objSelect.setCheckRatio(checkRatio);
            //Set and get data
            objSelect.setData();
            dataTable = objSelect.getDataTable();
            gbc.gridx = 0;
            gbc.gridy = 0;
            //Indetify suitable columns for table
            columns = identifyColumn();
            //Make Table
            this.displayTable = new JTable(dataTable, columns);
            //add Table to Panel
            this.centerPanel.add(new JScrollPane(displayTable), gbc);
        } //Show dish that has a lot of left over
        else if (command.equals("Hate"))
        {
            //remove pre-existing table 
            centerPanel.removeAll();
            //set target ratio to 0.75 ( a lot of food left over )
            checkRatio = 0.75;
            CheckRatioTable objSelect = new CheckRatioTable();
            //Set target table
            objSelect.setTargetTable(userTableSelection);
            //Set ratio
            objSelect.setCheckRatio(checkRatio);
            //Set and get data
            objSelect.setData();
            dataTable = objSelect.getDataTable();
            gbc.gridx = 0;
            gbc.gridy = 0;
            //Indetify suitable columns for table
            columns = identifyColumn();
            //Make Table
            this.displayTable = new JTable(dataTable, columns);
            //Add Table to Panel
            this.centerPanel.add(new JScrollPane(displayTable), gbc);
        } //Option for user to insert ratio themselve
        else if (command.equals("Advance"))
        {
            //Removing other components in the panel 
            //remove favorite button
            westPanel.remove(favoriteButton);
            //remove half button
            westPanel.remove(halfButton);
            //remove hate button 
            westPanel.remove(hateButton);
            //remove advance button
            westPanel.remove(advanceButton);
            gbc.insets = new Insets(50, 10, 10, 10);
            //Add 'ratio' label for textfield
            gbc.gridx = 0;
            gbc.gridy = 1;
            westPanel.add(ratioLabel, gbc);
            //Add textField under Label
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(10, 10, 10, 10);
            westPanel.add(ratioTextField, gbc);
            //Add 'Check' Button
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(30, 10, 30, 10);
            westPanel.add(checkButton, gbc);
            //add a back button for bottom Panel
            lowerPanel.add(backButton);
        } //Display table and get ratio that user inputed 
        else if (command.equals("Check"))
        {
            try
            {
                //remove pre-existing table 
                centerPanel.removeAll();
                //get user's ratio input
                checkRatio = Double.parseDouble(ratioTextField.getText());
                //set targeted ratio from user
                CheckRatioTable objSelect = new CheckRatioTable();
                //Set target table
                objSelect.setTargetTable(userTableSelection);
                //Set ratio
                objSelect.setCheckRatio(checkRatio);
                //Set and get data
                objSelect.setData();
                dataTable = objSelect.getDataTable();
                gbc.gridx = 0;
                gbc.gridy = 0;
                //Indetify suitable columns for table
                columns = identifyColumn();
                //make Table
                this.displayTable = new JTable(dataTable, columns);
                //Add Table to Panel
                this.centerPanel.add(new JScrollPane(displayTable), gbc);

            } // Detection if the user has not inpout anything into the textfield or enter different than a number
            catch (NumberFormatException nfe)
            {
                //Pop up error frame that will remind the user about the error
                UserError errorObj = new UserError("Enter a number please !!");
            } //Any other error within the system
            catch (Exception exceptionObj)
            {
                //Pop up error frame that will remind the user about the error
                SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
            }
        } //Resest the frame
        else if (command.equals("Back"))
        {
            //dispose the frame and open a new one
            this.dispose();
            new CheckRatio();
        }

        this.validate();
        this.repaint();
    }

    //main method for testing 
    public static void main(String args[])
    {
        CheckRatio objRatio = new CheckRatio();
    }

    //Method to return Columns name that macth with the table selected 
    private String[] identifyColumn()
    {
        //Declare an emtpy String [] as a return value
        String[] tableColumn =
        {
        };
        //Main Table selected
        if (userTableSelection.equals("Main Table"))
        {
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", " Ingredient", "Sauce ", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Entree Table selected
        else if (userTableSelection.equals("Entree"))
        {
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", " Ingredient", "Sauce ", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Ingredient table selected
        else if (userTableSelection.equals("Ingredient"))
        {
            String[] column =
            {
                "DishID", "DishName", " Ingredient", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Salad table selected
        else if (userTableSelection.equals("Salad"))
        {
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", " Ingredient", "Sauce ", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Sauce Table selected
        else if (userTableSelection.equals("Sauce"))
        {
            String[] column =
            {
                "DishID", "DishName", " Sauce", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Desert Table selected
        else if (userTableSelection.equals("Desert"))
        {
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Drink Table selected
        else if (userTableSelection.equals("Drink"))
        {
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        } //Fruit table selected
        else if (userTableSelection.equals("Fruit"))
        {
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", "Ratio"
            };
            //Asigned to return value
            tableColumn = column;
        }
        //returned the apporiated table header 
        return tableColumn;
    }
}
