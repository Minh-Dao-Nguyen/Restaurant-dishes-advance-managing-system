/*
 September 25th, 2020
 * This is a GUI class. This frame allows user to input a new dishes with its elements. Then the
program will display to the user the possiblity the custoners will like it when user press "predict".
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
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prediction extends JFrame implements ActionListener
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
    private JButton predictButton;
    private JButton ingredientDisplay;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    //JLabel
    private JLabel ingredientLabel;
    private JLabel ingredientNumberLabel;
    private JLabel messageLabel;
    //TextField
    private JTextField ingredientsTextField;
    private JTextField ingredientsTextField1;
    private JTextField ingredientsTextField2;
    private JTextField ingredientsTextField3;
    private JTextField ingredientsTextField4;
    private JTextField ingredientsTextField5;
    private JTextField ingredientsTextField6;
    private JTextField ingredientsTextField7;
    private JTextField ingredientsTextField8;
    private JTextField ingredientsTextField9;
    private int ingredientCount;
    //JComboBox
    private JComboBox ingredientNumberBox;
    private String[] ingredientNumber =
    {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    public Prediction()
    {
        super("Prediction");
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
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);

        //Ingredient field
        this.ingredientLabel = new JLabel("Ingredients");
        this.ingredientNumberLabel = new JLabel("Number of Ingredients");
        this.ingredientDisplay = new JButton("Display");
        ingredientDisplay.addActionListener(this);
        this.ingredientsTextField = new JTextField(10);
        this.ingredientsTextField1 = new JTextField(10);
        this.ingredientsTextField2 = new JTextField(10);
        this.ingredientsTextField3 = new JTextField(10);
        this.ingredientsTextField4 = new JTextField(10);
        this.ingredientsTextField5 = new JTextField(10);
        this.ingredientsTextField6 = new JTextField(10);
        this.ingredientsTextField7 = new JTextField(10);
        this.ingredientsTextField8 = new JTextField(10);
        this.ingredientsTextField9 = new JTextField(10);
        this.ingredientNumberBox = new JComboBox(ingredientNumber);
        ingredientNumberBox.addActionListener(this);

        this.predictButton = new JButton("Predict");
        predictButton.addActionListener(this);
        //Center Panel
        //Ingredient Fields
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(ingredientNumberLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(ingredientNumberBox, gbc);
        //Ingreident Display
        gbc.insets = new Insets(10, 50, 10, 85);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(ingredientLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(ingredientDisplay, gbc);
        //Predict Button
        gbc.gridx = 2;
        gbc.gridy = 1;
        centerPanel.add(predictButton, gbc);
        //Bottom panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 50, 20, 50);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
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
        String command = e.getActionCommand();
        if (command.equals("Close"))
        {
            this.dispose();
        }  else if (command.equals("Help"))
        {
            this.dispose();
            Help objHelp = new Help();
        } 
        else if(command.equals("Display"))
        {
            new IngredientDisplay();
        }else if (command.equals("Predict"))
        {
            try
            {
                //Set default ingredient count to 1 
                ingredientCount = 1;
                //Get the object of Calculation class 
                CalculatePrediction objPredict = new CalculatePrediction();
                //get the ingredient
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
                //Set the number of ingredient into the Calculation class
                objPredict.setIngredientCount(ingredientCount);
                // 1 Ingredients 
                if (ingredientCount >= 1)
                {
                    objPredict.setIngredient(ingredient);
                    // 2 Ingredients 
                    if (ingredientCount >= 2)
                    {
                        objPredict.setIngredient1(ingredient1);
                        // 3 Ingredients 
                        if (ingredientCount >= 3)
                        {
                            objPredict.setIngredient2(ingredient2);
                            // 4 Ingredients 
                            if (ingredientCount >= 4)
                            {
                                objPredict.setIngredient3(ingredient3);
                                // 5 Ingredients 
                                if (ingredientCount >= 5)
                                {
                                    objPredict.setIngredient4(ingredient4);
                                    // 6 Ingredients
                                    if (ingredientCount >= 6)
                                    {
                                        objPredict.setIngredient5(ingredient5);
                                        // 7 Ingredients 
                                        if (ingredientCount >= 7)
                                        {
                                            objPredict.setIngredient6(ingredient6);
                                            // 8 Ingredients 
                                            if (ingredientCount >= 8)
                                            {
                                                objPredict.setIngredient7(ingredient7);
                                                // 9 Ingredients
                                                if (ingredientCount >= 9)
                                                {
                                                    objPredict.setIngredient8(ingredient8);
                                                    // 10 Ingredients
                                                    if (ingredientCount == 10)
                                                    {
                                                        objPredict.setIngredient9(ingredient9);
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
                //Get the prediction and set calculation 
                objPredict.setPredictedRatio();
                this.messageLabel = new JLabel(Double.toString(objPredict.getPredictedRatio()));
                gbc.gridx = 2;
                gbc.gridy = 4;
                centerPanel.add(messageLabel, gbc);
                
            } catch (Exception exceptionObj)
            {
                SystemError objError = new SystemError("Something went wrong in the systen, please contact developer");
            }
        } else if (e.getSource() == ingredientNumberBox)
        {
            JComboBox cb = (JComboBox) e.getSource();
            String IngredientNumber = (String) cb.getSelectedItem();
            gbc.insets = new Insets(5, 10, 5, 10);
            if (IngredientNumber.equals("1"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                ingredientCount = 1;
            } else if (IngredientNumber.equals("2"))
            {
                resetIngredient();
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerPanel.add(ingredientsTextField, gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerPanel.add(ingredientsTextField1, gbc);
                ingredientCount = 2;
            } else if (IngredientNumber.equals("3"))
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
            } else if (IngredientNumber.equals("4"))
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
            } else if (IngredientNumber.equals("5"))
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
            } else if (IngredientNumber.equals("6"))
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
            } else if (IngredientNumber.equals("7"))
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
            } else if (IngredientNumber.equals("8"))
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
            } else if (IngredientNumber.equals("9"))
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
            } else if (IngredientNumber.equals("10"))
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
        }

        this.validate();
        this.repaint();
    }
    //Use to reset all the ingredient TextField
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

    public static void main(String args[])
    {
        Prediction objPrediction = new Prediction();
    }

}
