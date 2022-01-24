/*
September 20th 2020
 * This class is the home GUI class, the main frame for user to mauver to other frames/functions of the program.
 */
//package internalassesment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class Home extends JFrame implements ActionListener
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
    //JLabel
    private JLabel nameLabel;
    private JLabel picLabel;
    //JButton
    private JButton closeButton;
    private JButton newDishButton;
    private JButton inputButton;
    private JButton ratioButton;
    private JButton predictionButton;
    private JButton rankButton;
    private JButton dataButton;
    private JButton backButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private final URL PIC_FONT = getClass().getResource("HomePic.jpg");
    private final ImageIcon PIC
            = new ImageIcon(new ImageIcon(PIC_FONT).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));

    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    //Constructor 
    public Home()
    {
        //Size of the frame
        super("Home");
        this.setBounds(100, 100, 700, 500);

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
        //Panels
        //centerPanel
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
        //Right Panel
        this.eastPanel = new JPanel(new GridBagLayout());
        eastPanel.setBackground(SLIVER);
        this.add(eastPanel, BorderLayout.EAST);
        //Center Panel
        //Adding picture
        this.picLabel = new JLabel(PIC);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(picLabel, gbc);

        //Bottom panel
        gbc.insets = new Insets(20, 50, 20, 50);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        //Add close Buttons
        gbc.gridx = 0;
        gbc.gridy = 0;
        lowerPanel.add(closeButton, gbc);
        this.backButton = new JButton("Back");
        //add back (to welcome frame) buttons
        gbc.gridx = 1;
        gbc.gridy = 0;
        backButton.addActionListener(this);
        lowerPanel.add(backButton, gbc);
        //Left side
        gbc.insets = new Insets(50, 50, 50, 50);
        //New Dish Button
        this.newDishButton = new JButton("New Dish");
        newDishButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        westPanel.add(newDishButton, gbc);
        //Input Button
        this.inputButton = new JButton("Input");
        inputButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(inputButton, gbc);
        //Data Button
        this.dataButton = new JButton("Data");
        dataButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(dataButton, gbc);
        //Right side
        //Rank Button
        this.rankButton = new JButton("Rank");
        rankButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        eastPanel.add(rankButton, gbc);
        //Ratio Button
        this.ratioButton = new JButton("Ratio");
        ratioButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        eastPanel.add(ratioButton, gbc);
        //Predict Button
        this.predictionButton = new JButton("Prediction");
        predictionButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        eastPanel.add(predictionButton, gbc);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //Close the program 
        if (command.equals("Close"))
        {
            WarningClose objWarning = new WarningClose();
        } 
        //Return to Welcome Frame
        else if (command.equals("Back"))
        {
            this.dispose();
            Welcome objwelcome = new Welcome();
        } 
        //Open help Frame
        else if (command.equals("Help"))
        {
            Help objHelp = new Help();
        } 
        // Open data frame to view data 
        else if (command.equals("Data"))
        {
            Data objData = new Data();  
        } 
        //Open new Dish frame to input new Dish 
        else if (command.equals("New Dish"))
        {
            NewDish objNewDish = new NewDish();
        } 
        //Open input frame to input new Dish
        else if (command.equals("Input"))
        {
            Input objInput = new Input();
        } 
        //Open rank frame to view ranked table
        else if (command.equals("Rank"))
        {
            Rank objRank = new Rank();
        } 
        //Open ratio frame to view ratio
        else if (command.equals("Ratio"))
        {
            CheckRatio objRatio = new CheckRatio();
        } 
        //Open prediction Frame 
        else if (command.equals("Prediction"))
        {
            Prediction objPrediction = new Prediction();
        }
        this.validate();
        this.repaint();
    }
    //Main method for testing 
    public static void main(String[] args)
    {
        Home objHome = new Home();
    }
}
