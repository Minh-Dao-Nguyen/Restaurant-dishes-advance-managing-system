/*
September 25th, 2020
 * This is GUI class. It allows user to input dishs and their components into database.
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewDish extends JFrame implements ActionListener
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
    //input Button for entree type
    private JButton inputEntreeButton;
    //input Button for salad type
    private JButton inputSaladButton;
    //input Button for drink type
    private JButton inputDrinkButton;
    //input Button for fruit type
    private JButton inputFruitButton;
    //input Button for desert type
    private JButton inputDesertButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
    //JLabel
    private JLabel nameLabel;
    private JLabel ingredientLabel;
    private JLabel saucesLabel;
    private JLabel inputManyLabel;
    //TextField
    //textField for ingredient 1
    private JTextField ingredientsTextField;
    //textField for ingredient 2
    private JTextField ingredientsTextField1;
    //textField for ingredient 3
    private JTextField ingredientsTextField2;
    //textField for ingredient 4
    private JTextField ingredientsTextField3;
    //textField for ingredient 5
    private JTextField ingredientsTextField4;
    //textField for ingredient 6
    private JTextField ingredientsTextField5;
    //textField for ingredient 7
    private JTextField ingredientsTextField6;
    //textField for ingredient 8
    private JTextField ingredientsTextField7;
    //textField for ingredient 9
    private JTextField ingredientsTextField8;
    //textField for ingredient 10
    private JTextField ingredientsTextField9;
    //textField for sauce 
    private JTextField saucesTextField;
    //textField for the name of the dish  
    private JTextField nameTextField;
    //JComboBox
    private JComboBox dishTypeOption;
    //Option in JCombo Box
    private String[] dishType =
    {
        "Entree", "Salad", "Desert", "Fruit", "Drink"
    };
    //JCombp Box for the user to choose how many ingredients are there in the dish 
    private JComboBox ingredientNumberBox;
    private String[] ingredientNumber =
    {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };
    //Gridlayout ( for display purpose )
    GridBagConstraints gbc = new GridBagConstraints();
    //Number of Ingredient 
    private int ingredientCount;
    //JCheckbox 
    private JCheckBox inputMany;

    //Constructor 
    public NewDish()
    {
        //Frame size 
        super("New Dish Input");
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
        //top panel 
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        //bottom Panel 
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        //left Panel 
        this.westPanel = new JPanel(new GridBagLayout());
        westPanel.setBackground(SLIVER);
        this.add(westPanel, BorderLayout.WEST);
        //Bottom panel
        //add close Button 
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);

        //West Panel 
        //add JComboBox for dishType
        this.dishTypeOption = new JComboBox(dishType);
        dishTypeOption.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 50, 50, 50);
        westPanel.add(dishTypeOption, gbc);
        gbc.insets = new Insets(50, 5, 5, 5);
        //Add checkbox for many input and its label
        this.inputManyLabel = new JLabel("Input Many");
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(inputManyLabel, gbc);
        this.inputMany = new JCheckBox();
        gbc.insets = new Insets(5, 5, 50, 5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(inputMany, gbc);
        gbc.insets = new Insets(50, 50, 50, 50);
        //addind Dish Name label and TextField for teh name of the dish 
        this.nameLabel = new JLabel("Dish Name");
        this.nameTextField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        westPanel.add(nameLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        westPanel.add(nameTextField, gbc);

        //center Panel
        //Label for ingredient 
        this.ingredientLabel = new JLabel("Ingredients");
        //Label for sauce
        this.saucesLabel = new JLabel("Sauces and Spices");
        //Declareing textfield
        //textField for ingredient 1
        this.ingredientsTextField = new JTextField(10);
        //textField for sauce
        this.saucesTextField = new JTextField(10);
        //textField for ingredient 2
        this.ingredientsTextField1 = new JTextField(10);
        //textField for ingredient 3
        this.ingredientsTextField2 = new JTextField(10);
        //textField for ingredient 4
        this.ingredientsTextField3 = new JTextField(10);
        //textField for ingredient 5
        this.ingredientsTextField4 = new JTextField(10);
        //textField for ingredient 6
        this.ingredientsTextField5 = new JTextField(10);
        //textField for ingredient 7
        this.ingredientsTextField6 = new JTextField(10);
        //textField for ingredient 8
        this.ingredientsTextField7 = new JTextField(10);
        //textField for ingredient 9
        this.ingredientsTextField8 = new JTextField(10);
        //textField for ingredient 10
        this.ingredientsTextField9 = new JTextField(10);
        
        //Declaring Buttons
        //input Button for input type
        this.inputSaladButton = new JButton("Input Salad");
        inputSaladButton.addActionListener(this);
        //input Button for entree type
        this.inputEntreeButton = new JButton("Input Entree");
        inputEntreeButton.addActionListener(this);
        //input Button for desert type
        this.inputDesertButton = new JButton("Input Desert");
        inputDesertButton.addActionListener(this);
        //input Button for drink type
        this.inputDrinkButton = new JButton("Input Drink");
        inputDrinkButton.addActionListener(this);
        //input Button for fruit type
        this.inputFruitButton = new JButton("Input Fruit");
        inputFruitButton.addActionListener(this);
        //Number of ingredient jComboBox
        this.ingredientNumberBox = new JComboBox(ingredientNumber);
        ingredientNumberBox.addActionListener(this);

        //Default entree input display when the frame is opended 
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(ingredientLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(saucesLabel, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        centerPanel.add(inputEntreeButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(ingredientNumberBox, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(saucesTextField, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String dishName;
        String ingredient;
        String ingredient1;
        String ingredient2;
        String ingredient3;
        String ingredient4;
        String ingredient5;
        String ingredient6;
        String ingredient7;
        String ingredient8;
        String ingredient9;
        String sauce;
        String dishType;
        String command = e.getActionCommand();
        //Table Name
        String dishNameTable = "DishName";
        String dishTypeTable = "DishType";
        String dishRatioTable = "DishRatio";
        String ingredientTable = "Ingredient";
        String sauceTable = "Sauce";
        //Column Name
        String dishNameColumn = "Dish_Name";
        String dishTypeColumn = "Type";
        String ratioColumn = "Ratio";
        String ingredientColumn = "Ingredient";
        String sauceColumn = "Sauce";
        //Database Connection
        String dbName = "CUISINES";
        JavaDatabase objDb = new JavaDatabase(dbName);
        Connection myDbConn = null;
        myDbConn = objDb.getDbConn();
        //Declartion for Input
        double ratio = 1000;
        int dishID;
        //Control Buttons  
        //Close the frame
        if (command.equals("Close"))
        {
            this.dispose();
        } 
        //open help frame
        else if (command.equals("Help"))
        {
            Help objHelp = new Help();
        } //Options for inout type 
        else if (e.getSource() == dishTypeOption)
        {
            JComboBox cb = (JComboBox) e.getSource();
            //get user type of dish selection
            String DishType = (String) cb.getSelectedItem();
            if (DishType.equals("Entree"))
            {
                centerPanel.removeAll();
                gbc.insets = new Insets(10, 10, 10, 10);
                //add ingredient Label
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerPanel.add(ingredientLabel, gbc);
                //add sauce label
                gbc.gridx = 1;
                gbc.gridy = 0;
                centerPanel.add(saucesLabel, gbc);
                //Add input button for entree type
                gbc.gridx = 3;
                gbc.gridy = 1;
                centerPanel.add(inputEntreeButton, gbc);
                //add number of ingredient selections(jComboBox)
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerPanel.add(ingredientNumberBox, gbc);
                //add Sauce TextField
                gbc.gridx = 1;
                gbc.gridy = 1;
                centerPanel.add(saucesTextField, gbc);

            } else if (DishType.equals("Salad"))
            {
                centerPanel.removeAll();
                gbc.insets = new Insets(10, 10, 10, 10);
                //add ingredient Label
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerPanel.add(ingredientLabel, gbc);
                //add sauce Label
                gbc.gridx = 1;
                gbc.gridy = 0;
                centerPanel.add(saucesLabel, gbc);
                //Add input button for salad type
                gbc.gridx = 3;
                gbc.gridy = 1;
                centerPanel.add(inputSaladButton, gbc);
                //add number of ingredient selections (jComboBox)
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerPanel.add(ingredientNumberBox, gbc);
                //add Sauce TextField
                gbc.gridx = 1;
                gbc.gridy = 1;
                centerPanel.add(saucesTextField, gbc);
            } else if (DishType.equals("Desert"))
            {
                centerPanel.removeAll();
                gbc.insets = new Insets(10, 10, 10, 10);
                //add sauce Label
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerPanel.add(saucesLabel, gbc);
                //Add input button for desert type
                gbc.gridx = 1;
                gbc.gridy = 1;
                centerPanel.add(inputDesertButton, gbc);
                //add Sauce TextField
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerPanel.add(saucesTextField, gbc);
            } else if (DishType.equals("Fruit"))
            {
                centerPanel.removeAll();
                gbc.insets = new Insets(10, 10, 10, 10);
                //Add input button for fruit type
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerPanel.add(inputFruitButton, gbc);
            } else if (DishType.equals("Drink"))
            {
                centerPanel.removeAll();
                //Add input button for drink type
                centerPanel.add(inputDrinkButton, gbc);
            }
        } 
        //Number of Ingredients selection from the user 
        else if (e.getSource() == ingredientNumberBox)
        {
            JComboBox cb = (JComboBox) e.getSource();
            //get user selection
            String IngredientNumber = (String) cb.getSelectedItem();
            gbc.insets = new Insets(5, 10, 5, 10);
            //Adding the number of textfield according the numeber of ingredients there are
            // 1 Ingredient
            if (IngredientNumber.equals("1"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                ingredientCount = 1;
            } 
            //2 ingredients
            else if (IngredientNumber.equals("2"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                ingredientCount = 2;
            }
            //3 ingredients
            else if (IngredientNumber.equals("3"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                ingredientCount = 3;
            } 
            //4 ingredients
            else if (IngredientNumber.equals("4"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                ingredientCount = 4;
            } 
            //5 ingredients
            else if (IngredientNumber.equals("5"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerPanel.add(ingredientsTextField4, gbc);
                ingredientCount = 5;
            } 
            //6 ingredients
            else if (IngredientNumber.equals("6"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerPanel.add(ingredientsTextField4, gbc);
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerPanel.add(ingredientsTextField5, gbc);
                ingredientCount = 6;
            } 
            //7 ingredients
            else if (IngredientNumber.equals("7"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerPanel.add(ingredientsTextField4, gbc);
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerPanel.add(ingredientsTextField5, gbc);
                gbc.gridx = 0;
                gbc.gridy = 8;
                centerPanel.add(ingredientsTextField6, gbc);
                ingredientCount = 7;
            } 
            //8 ingredients
            else if (IngredientNumber.equals("8"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerPanel.add(ingredientsTextField4, gbc);
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerPanel.add(ingredientsTextField5, gbc);
                gbc.gridx = 0;
                gbc.gridy = 8;
                centerPanel.add(ingredientsTextField6, gbc);
                gbc.gridx = 0;
                gbc.gridy = 9;
                centerPanel.add(ingredientsTextField7, gbc);
                ingredientCount = 8;
            } 
            //9 ingredients
            else if (IngredientNumber.equals("9"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerPanel.add(ingredientsTextField4, gbc);
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerPanel.add(ingredientsTextField5, gbc);
                gbc.gridx = 0;
                gbc.gridy = 8;
                centerPanel.add(ingredientsTextField6, gbc);
                gbc.gridx = 0;
                gbc.gridy = 9;
                centerPanel.add(ingredientsTextField7, gbc);
                gbc.gridx = 0;
                gbc.gridy = 10;
                centerPanel.add(ingredientsTextField8, gbc);
                ingredientCount = 9;
            } 
            //10 ingredients
            else if (IngredientNumber.equals("10"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerPanel.add(ingredientsTextField2, gbc);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerPanel.add(ingredientsTextField3, gbc);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerPanel.add(ingredientsTextField4, gbc);
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerPanel.add(ingredientsTextField5, gbc);
                gbc.gridx = 0;
                gbc.gridy = 8;
                centerPanel.add(ingredientsTextField6, gbc);
                gbc.gridx = 0;
                gbc.gridy = 9;
                centerPanel.add(ingredientsTextField7, gbc);
                gbc.gridx = 0;
                gbc.gridy = 10;
                centerPanel.add(ingredientsTextField8, gbc);
                gbc.gridx = 0;
                gbc.gridy = 11;
                centerPanel.add(ingredientsTextField9, gbc);
                ingredientCount = 10;
            }
        } //Input
        //ENTREE TYPE
        else if (command.equals("Input Entree"))
        {
            //get user input 
            //dishName input
            dishName = nameTextField.getText();
            //sauce input
            sauce = saucesTextField.getText();
            dishType = "Entree";
            //Generate ID
            dishID = objDb.getLatestID() + 1;
            //DishName input into database
            try
            {
                objDb.insertData(dishNameTable, dishID, dishNameColumn, dishName);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //DishType input into database
            try
            {
                objDb.insertData(dishTypeTable, dishID, dishTypeColumn, dishType);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ingredient input into database
            try
            {
                ingredient = ingredientsTextField.getText();
                ingredient1 = ingredientsTextField1.getText();
                ingredient2 = ingredientsTextField2.getText();
                ingredient3 = ingredientsTextField3.getText();
                ingredient4 = ingredientsTextField4.getText();
                ingredient5 = ingredientsTextField5.getText();
                ingredient6 = ingredientsTextField6.getText();
                ingredient7 = ingredientsTextField7.getText();
                ingredient8 = ingredientsTextField8.getText();
                ingredient9 = ingredientsTextField9.getText();
                // 1 Ingredient Input 
                if (ingredientCount >= 1)
                {
                    objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient);
                     // 2 Ingredient Input 
                    if (ingredientCount >= 2)
                    {
                        objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient1);
                         // 3 Ingredient Input 
                        if (ingredientCount >= 3)
                        {
                            objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient2);
                             // 4 Ingredient Input 
                            if (ingredientCount >= 4)
                            {
                                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient3);
                                 // 5 Ingredient Input 
                                if (ingredientCount >= 5)
                                {
                                    objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient4);
                                     // 6 Ingredient Input 
                                    if (ingredientCount >= 6)
                                    {
                                        objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient5);
                                         // 7 Ingredient Input 
                                        if (ingredientCount >= 7)
                                        {
                                            objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient6);
                                             // 8 Ingredient Input 
                                            if (ingredientCount >= 8)
                                            {
                                                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient7);
                                                 // 9 Ingredient Input 
                                                if (ingredientCount >= 9)
                                                {
                                                    objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient8);
                                                     // 10 Ingredient Input 
                                                    if (ingredientCount == 10)
                                                    {
                                                        objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient9);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Sauce input into database
            try
            {
                objDb.insertData(sauceTable, dishID, sauceColumn, sauce);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ratio input into database
            try
            {
                objDb.insertData(dishRatioTable, dishID, ratioColumn, ratio);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            input();
        } //SALAD TYPE
        else if (command.equals("Input Salad"))
        {
            dishName = nameTextField.getText();
            sauce = saucesTextField.getText();
            dishType = "Salad";
            //Generate ID
            dishID = objDb.generateID();
            try
            {
                objDb.insertData(dishNameTable, dishID, dishNameColumn, dishName);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //DishType input into database
            try
            {
                objDb.insertData(dishTypeTable, dishID, dishTypeColumn, dishType);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ingredient input into database
            try
            {
                ingredient = ingredientsTextField.getText();
                ingredient1 = ingredientsTextField1.getText();
                ingredient2 = ingredientsTextField2.getText();
                ingredient3 = ingredientsTextField3.getText();
                ingredient4 = ingredientsTextField4.getText();
                ingredient5 = ingredientsTextField5.getText();
                ingredient6 = ingredientsTextField6.getText();
                ingredient7 = ingredientsTextField7.getText();
                ingredient8 = ingredientsTextField8.getText();
                ingredient9 = ingredientsTextField9.getText();
                 // 1 Ingredient Input 
                if (ingredientCount >= 1)
                {
                    objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient);
                     // 2 Ingredient Input 
                    if (ingredientCount >= 2)
                    {
                        objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient1);
                         // 3 Ingredient Input 
                        if (ingredientCount >= 3)
                        {
                            objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient2);
                             // 4 Ingredient Input 
                            if (ingredientCount >= 4)
                            {
                                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient3);
                                 // 5 Ingredient Input 
                                if (ingredientCount >= 5)
                                {
                                    objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient4);
                                     // 6 Ingredient Input 
                                    if (ingredientCount >= 6)
                                    {
                                        objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient5);
                                         // 7 Ingredient Input 
                                        if (ingredientCount >= 7)
                                        {
                                            objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient6);
                                             // 8 Ingredient Input 
                                            if (ingredientCount >= 8)
                                            {
                                                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient7);
                                                 // 9 Ingredient Input 
                                                if (ingredientCount >= 9)
                                                {
                                                    objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient8);
                                                     // 10 Ingredient Input 
                                                    if (ingredientCount == 10)
                                                    {
                                                        objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient9);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Sauce input into database
            try
            {
                objDb.insertData(sauceTable, dishID, sauceColumn, sauce);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ratio input into database
            try
            {
                objDb.insertData(dishRatioTable, dishID, ratioColumn, ratio);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            input();
        } //DESERT TYPE
        else if (command.equals("Input Desert"))
        {
            dishName = nameTextField.getText();
            sauce = saucesTextField.getText();
            ingredient = "";
            dishType = "Desert";
            //Generate ID
            dishID = objDb.generateID();
            try
            {
                objDb.insertData(dishNameTable, dishID, dishNameColumn, dishName);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //DishType input into database
            try
            {
                objDb.insertData(dishTypeTable, dishID, dishTypeColumn, dishType);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ingredient input into database
            try
            {
                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Sauce input into database
            try
            {
                objDb.insertData(sauceTable, dishID, sauceColumn, sauce);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ratio input into database
            try
            {
                objDb.insertData(dishRatioTable, dishID, ratioColumn, ratio);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            input();
        } //Fruit Type
        else if (command.equals("Input Fruit"))
        {
            dishName = nameTextField.getText();
            ingredient = "";
            sauce = "";
            dishType = "Fruit";
            //Generate ID
            dishID = objDb.generateID();
            try
            {
                objDb.insertData(dishNameTable, dishID, dishNameColumn, dishName);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //DishType input into database
            try
            {
                objDb.insertData(dishTypeTable, dishID, dishTypeColumn, dishType);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ingredient input into database
            try
            {
                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Sauce input into database
            try
            {
                objDb.insertData(sauceTable, dishID, sauceColumn, sauce);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ratio input into database
            try
            {
                objDb.insertData(dishRatioTable, dishID, ratioColumn, ratio);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            input();
        } //Drink Table
        else if (command.equals("Input Drink"))
        {
            dishName = nameTextField.getText();
            ingredient = "";
            sauce = "";
            dishType = "Drink";
            //Generate ID
            dishID = objDb.generateID();
            try
            {
                objDb.insertData(dishNameTable, dishID, dishNameColumn, dishName);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //DishType input into database
            try
            {
                objDb.insertData(dishTypeTable, dishID, dishTypeColumn, dishType);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ingredient input into database
            try
            {
                objDb.insertData(ingredientTable, dishID, ingredientColumn, ingredient);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Sauce input into database
            try
            {
                objDb.insertData(sauceTable, dishID, sauceColumn, sauce);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            //Ratio input into database
            try
            {
                objDb.insertData(dishRatioTable, dishID, ratioColumn, ratio);
            } catch (Exception exceptionObj)
            {
                SystemError errorObj = new SystemError("System error:Something went wrong in the systen, please contact developer");
            }
            input();
        }

        this.validate();
        this.repaint();
    }
    //main method for testing
    public static void main(String args[])
    {
        NewDish objNewDish = new NewDish();
    }
    //After Inputting method ( open data frame if only input once)
    private void input()
    {
        //pop up frame telling user inpout is sucessful 
        new SystemMessage("Sucessfully Input");
        //if user choose to input more than once dish 
        if (inputMany.isSelected())
        {
            this.dispose();
            new NewDish();
        } 
        //if user choose to only inout once
        else
        {
            this.dispose();
            new Data();
        }
    }
    //Rest all Ingredient textfields method
    private void resetIngredient()
    {
        this.centerPanel.remove(ingredientsTextField);
        this.centerPanel.remove(ingredientsTextField1);
        this.centerPanel.remove(ingredientsTextField2);
        this.centerPanel.remove(ingredientsTextField3);
        this.centerPanel.remove(ingredientsTextField4);
        this.centerPanel.remove(ingredientsTextField5);
        this.centerPanel.remove(ingredientsTextField6);
        this.centerPanel.remove(ingredientsTextField7);
        this.centerPanel.remove(ingredientsTextField8);
        this.centerPanel.remove(ingredientsTextField9);
    }

}
