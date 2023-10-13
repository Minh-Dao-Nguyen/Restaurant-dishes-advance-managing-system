/*
September 30th 2020
 * This GUI class display a table with ingrdient only
 */
//package internalassesment;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IngredientDisplay extends JFrame implements ActionListener
{

    //Color
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    //JButton
    private JButton closeButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel lowerPanel;
    //Table
    private JTable table;

    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    //Constructor 
    public IngredientDisplay()
    {
        //size of the frame
        super("Dish Input Selection");
        this.setBounds(275, 100, 600, 500);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Panel
        //center Panel 
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        //Bottom Panel 
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        //adding done/closing button
        this.closeButton = new JButton("Done");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);
        //Establish connection with Database through JavaDatabase class
        String dbName = "CUISINES";
        JavaDatabase objDb = new JavaDatabase(dbName);
        Connection myDbConn = null;
        myDbConn = objDb.getDbConn();
        //Get ingredient Data (ingredient only) using method from ingredient class
        //calling constructor 
        Ingredient ingredient = new Ingredient();
        //set and get data 
        ingredient.setIngredientTable();
        ArrayList<ArrayList<String>> ingredientArray = ingredient.getAllIngredientName();
        //columns for Table
        String[] column =
        {
            "Ingredient"
        };
        //turn data into Object[] [] to display in JTable
        Object[][] dataTable = objDb.to2dArray(ingredientArray);
        //making JTable
        this.table = new JTable(dataTable, column);
        //add JTable to Panel 
        this.centerPanel.add(new JScrollPane(table), gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //closing this frame
        if (command.equals("Done"))
        {
            this.dispose();
        }

        this.validate();
        this.repaint();
    }
    //main method for testing
    public static void main(String args[])
    {
        IngredientDisplay selectionObj = new IngredientDisplay();
    }
}
