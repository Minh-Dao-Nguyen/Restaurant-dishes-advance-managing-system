/*
September 20th 2020
 * This is GUi class. This frame shows the user the rank ( based on ratio) of specific dishes. 
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Rank extends JFrame implements ActionListener
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
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
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
        "Main Rank Table", "Entree Rank Table", "Ingredients Rank Table", "Salad Rank Table",
        "Sauce Rank Table", "Desert Rank Table", "Drink Rank Table"
    };
    private JComboBox rankOption;
    //2d Array 
    private Object[][] inputData;
    //JLabel
    private JLabel messageLabel;

    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    public Rank()
    {
        super("Rank");
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
        this.westPanel = new JPanel(new GridBagLayout());
        westPanel.setBackground(SLIVER);
        this.add(westPanel, BorderLayout.WEST);
        //Bottom panel
        gbc.insets = new Insets(20, 50, 20, 50);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 5;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);

        //West Panel
        this.rankOption = new JComboBox(tableName);
        rankOption.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        westPanel.add(rankOption, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String targetTable;
        String dbName = "CUISINES";
        String command = e.getActionCommand();
        Object[][] dataTable;
        if (command.equals("Close"))
        {
            this.dispose();
        }
        
        else if (command.equals("Help"))
        {
            this.dispose();
            Help objHelp = new Help();
        }
        else if (e.getSource() == rankOption)
        {
            JComboBox cb = (JComboBox) e.getSource();
            String table = (String) cb.getSelectedItem();
            String[] column =
            {
                "Dish ID", "Type", "Dish Name", " Ingredient", "Sauce ", "Ratio"
            };

            if (table.equals("Main Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Main Table";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    this.mainTable = new JTable(dataTable, column);
                    this.centerPanel.add(new JScrollPane(mainTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }
            } else if (table.equals("Entree Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Entree";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    this.entreeTable = new JTable(dataTable, column);
                    this.centerPanel.add(new JScrollPane(entreeTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } else if (table.equals("Ingredients Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Ingredient";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    String[] ingredientColumn =
                    {
                        "DishID", "DishName", " Ingredient", "Ratio"
                    };
                    this.ingredientTable = new JTable(dataTable, ingredientColumn);
                    this.centerPanel.add(new JScrollPane(ingredientTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } else if (table.equals("Salad Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Salad";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    this.saladTable = new JTable(dataTable, column);
                    this.centerPanel.add(new JScrollPane(saladTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } else if (table.equals("Sauce Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Sauce";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    String[] columnSauce =
                    {
                        "DishID", "DishName", " Sauce", "Ratio"
                    };
                    this.sauceTable = new JTable(dataTable, columnSauce);
                    this.centerPanel.add(new JScrollPane(sauceTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } else if (table.equals("Desert Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Desert";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    this.desertTable = new JTable(dataTable, column);
                    this.centerPanel.add(new JScrollPane(desertTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            } else if (table.equals("Drink Rank Table"))
            {
                centerPanel.removeAll();
                targetTable = "Drink";
                try
                {
                    centerPanel.removeAll();
                    RankedTable objRank = new RankedTable();
                    objRank.setTargetTable(targetTable);
                    objRank.setData();
                    dataTable = objRank.getDataTable();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    this.drinkTable = new JTable(dataTable, column);
                    this.centerPanel.add(new JScrollPane(drinkTable), gbc);
                } catch (Exception exceptionObj)
                {
                    this.dispose();
                    SystemError errorObj = new SystemError("System error: There maybe no data in database for this category.");
                }

            }
        }
        this.validate();
        this.repaint();
    }

    public static void main(String args[])
    {
        Rank objRank = new Rank();
    }
}
