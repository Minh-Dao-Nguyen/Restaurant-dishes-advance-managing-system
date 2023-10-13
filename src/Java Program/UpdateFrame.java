/*
Spetember 22nd 2020
 *This frame is used for updateing data
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
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateFrame extends JFrame implements ActionListener
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
    private JButton typeButton;
    private JButton nameButton;
    private JButton ingredientButton;
    private JButton sauceButton;
    private JButton updateButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    //JLabel
    private JLabel ingredientLabel;
    private JLabel nameLabel;
    private JLabel dishID;
    private JLabel sauceLabel;
    //JTextField
    private JTextField nameTextField;
    private JTextField ingredientTextField;
    private JTextField sauceTextField;
    private JTextField dishIDTextField;
    //JComboBox for Type
    private String[] typeName =
    {
        "Entree", "Desert", "Fruit", "Drink", "Salad"
    };
    private JComboBox typeOption;
    private String typeSelect;
    //Boolean to check which update the user want to make
    private boolean typeUpdate;
    private boolean nameUpdate;
    private boolean ingredientUpdate;
    private boolean sauceUpdate;

    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    public UpdateFrame()
    {
        super("Update");
        this.setBounds(275, 100, 600, 400);

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
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        //Bottom panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.closeButton = new JButton("ok");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);
        //Declare JCombox 
        this.typeSelect = "";
        this.typeOption = new JComboBox(typeName);
        typeOption.addActionListener(this);
        //Declare Labels
        this.ingredientLabel = new JLabel("Ingredient");
        this.nameLabel = new JLabel("Dish Name");
        this.dishID = new JLabel("Dish ID");
        this.sauceLabel = new JLabel("Sauce");
        //Declare Buttons
        this.typeButton = new JButton("Dish Type");
        this.typeButton.addActionListener(this);
        this.nameButton = new JButton("Dish Name");
        this.nameButton.addActionListener(this);
        this.ingredientButton = new JButton("Ingredient");
        this.ingredientButton.addActionListener(this);
        this.sauceButton = new JButton("Sauce");
        this.sauceButton.addActionListener(this);
        this.updateButton = new JButton("Update");
        this.updateButton.addActionListener(this);
        //Declare TextField
        this.nameTextField = new JTextField(5);
        this.ingredientTextField = new JTextField(5);
        this.sauceTextField = new JTextField(5);
        this.dishIDTextField = new JTextField(5);
        //Set boolean to default
        this.typeUpdate = false;
        this.nameUpdate = false;
        this.sauceUpdate = false;
        this.ingredientUpdate = false;
        //CenterPanel
        //add Buttons
        gbc.insets = new Insets(20, 50, 20, 50);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(nameButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        centerPanel.add(typeButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(ingredientButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        centerPanel.add(sauceButton, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if (command.equals("ok"))
        {
            this.dispose();
        } else if (command.equals("Help"))
        {
            Help objHelp = new Help();
        } 
        //if dishType update is selected
        else if (command.equals("Dish Type"))
        {
            //add dishID
            gbc.insets = new Insets(20, 50, 20, 50);
            gbc.gridx = 0;
            gbc.gridy = 0;
            centerPanel.add(dishID, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            centerPanel.add(dishIDTextField, gbc);
            removeOptions();
            gbc.gridx = 1;
            gbc.gridy = 0;
            centerPanel.add(typeOption, gbc);
            gbc.gridx = 2;
            gbc.gridy = 0;
            centerPanel.add(updateButton, gbc);
            this.typeUpdate = true;
        } 
        //if dish Name update is selected
        else if (command.equals("Dish Name"))
        {
            //add dishID
            gbc.insets = new Insets(20, 50, 20, 50);
            gbc.gridx = 0;
            gbc.gridy = 0;
            centerPanel.add(dishID, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            centerPanel.add(dishIDTextField, gbc);
            removeOptions();
            gbc.gridx = 1;
            gbc.gridy = 0;
            centerPanel.add(nameLabel, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            centerPanel.add(nameTextField, gbc);
            gbc.gridx = 2;
            gbc.gridy = 1;
            centerPanel.add(updateButton, gbc);
            this.nameUpdate = true;
        } 
        //if ingredeint update is selected
        else if (command.equals("Ingredient"))
        {
            //add dishID
            gbc.insets = new Insets(20, 50, 20, 50);
            gbc.gridx = 0;
            gbc.gridy = 0;
            centerPanel.add(dishID, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            centerPanel.add(dishIDTextField, gbc);
            removeOptions();
            gbc.gridx = 1;
            gbc.gridy = 0;
            centerPanel.add(ingredientLabel, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            centerPanel.add(ingredientTextField, gbc);
            gbc.gridx = 2;
            gbc.gridy = 1;
            centerPanel.add(updateButton, gbc);
            this.ingredientUpdate = true;
        } 
        //if sauce update is selected
        else if (command.equals("Sauce"))
        {
            //add dishID
            gbc.insets = new Insets(20, 50, 20, 50);
            gbc.gridx = 0;
            gbc.gridy = 0;
            centerPanel.add(dishID, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            centerPanel.add(dishIDTextField, gbc);
            removeOptions();
            gbc.gridx = 1;
            gbc.gridy = 0;
            centerPanel.add(sauceLabel, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            centerPanel.add(sauceTextField, gbc);
            gbc.gridx = 2;
            gbc.gridy = 1;
            centerPanel.add(updateButton, gbc);
            this.sauceUpdate = true;
        } else if (e.getSource() == typeOption)
        {
            JComboBox cb = (JComboBox) e.getSource();
            typeSelect = (String) cb.getSelectedItem();

        } //Update
        else if (command.equals("Update"))
        {
            //get user input
            //dish name
            String name = nameTextField.getText();
            //ingredient
            String ingredient = ingredientTextField.getText();
            //sauce
            String sauce = sauceTextField.getText();
            //dish ID
            int dishID = Integer.parseInt(dishIDTextField.getText());
            String dbName = "CUISINES";
            JavaDatabase objDB = new JavaDatabase(dbName);
            Connection myDbConn = null;
            myDbConn = objDB.getDbConn();
            try
            {
                //Update dish Type
                if (typeUpdate == true)
                {
                    //if there are nothing inside the textfield
                    if (typeSelect.equals(""))
                    {
                        UserError objUserError = new UserError("Please select the type you want to change to");
                    } else
                    {
                        objDB.update("DishType", dishID, "Type", typeSelect);
                        SystemMessage objMessage = new SystemMessage("Sucessfully Update");
                    }
                } 
                //Update the ingredient
                else if (ingredientUpdate == true)
                {
                    //if there are nothing inside the textfield
                    if (ingredient.equals(""))
                    {
                        UserError objUserError = new UserError("You cannot leave it blank");
                    } else
                    {
                        objDB.update("Ingredient", dishID, "ingredient", ingredient);
                        SystemMessage objMessage = new SystemMessage("Sucessfully Update");
                    }
                } 
                //update the sauce of the dish 
                else if (sauceUpdate == true)
                {
                    //if there are nothing inside the textfield
                    if (sauce.equals(""))
                    {
                        UserError objUserError = new UserError("You cannot leave it blank");
                    } else
                    {
                        objDB.update("Sauce", dishID, "Sauce", sauce);
                        SystemMessage objMessage = new SystemMessage("Sucessfully Update");
                    }
                } 
                //Update the name of the dish 
                else if (nameUpdate == true)
                {
                    //if there are nothing inside the textfield
                    if (name.equals(""))
                    {
                        UserError objUserError = new UserError("You cannot leave it blank");
                    } else
                    {
                        objDB.update("DishName", dishID, "Dish_Name", name);
                        SystemMessage objMessage = new SystemMessage("Sucessfully Update");

                    }
                }
            } catch (NumberFormatException en)
            {
                SystemError objError = new SystemError("Please Enter a Number in DishID");
            } catch (Exception exceptionObj)
            {
                SystemError objError = new SystemError("Something went wrong in the systen, please contact developer");
            }

        }

        this.validate();
        this.repaint();
    }
    //remove otehr options when one is selected
    private void removeOptions()
    {
        centerPanel.remove(typeButton);
        centerPanel.remove(nameButton);
        centerPanel.remove(ingredientButton);
        centerPanel.remove(sauceButton);
    }
    //reset the frame
    private void reset()
    {
        this.dispose();
        new UpdateFrame();
    }
    //main method for testing
    public static void main(String args[])
    {
        UpdateFrame objUpdate = new UpdateFrame();
    }
}
