/*
September 25th, 2020
This is GUI class. This frame provides user with additional helps/tutorals abput the program.
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Help extends JFrame implements ActionListener
{

    //Pictures
    //Home Frame Picture
    private final URL HOMEPIC = getClass().getResource("HomeSS.png");
    private final ImageIcon HOME_PIC
            = new ImageIcon(new ImageIcon(HOMEPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));
    //Data Frame Picture
    private final URL DATAPIC = getClass().getResource("Data.png");
    private final ImageIcon DATA_PIC
            = new ImageIcon(new ImageIcon(DATAPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));
    //New Dish Frame Picture
    private final URL NEWDISHPIC = getClass().getResource("NewDish.png");
    private final ImageIcon NEWDISH_PIC
            = new ImageIcon(new ImageIcon(NEWDISHPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));
    //Input Frame Picture
    private final URL INPUTPIC = getClass().getResource("Input.png");
    private final ImageIcon INPUT_PIC
            = new ImageIcon(new ImageIcon(INPUTPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));
    //Ratio Frame Picture
    private final URL RATIOPIC = getClass().getResource("Ratio.png");
    private final ImageIcon RATIO_PIC
            = new ImageIcon(new ImageIcon(RATIOPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));
    //Rank Frame Picture
    private final URL RANKPIC = getClass().getResource("Rank.png");
    private final ImageIcon RANK_PIC
            = new ImageIcon(new ImageIcon(RANKPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));
    //Prediction Frame Picture
    private final URL PREDICTIONPIC = getClass().getResource("Prediction.png");
    private final ImageIcon PREDICTION_PIC
            = new ImageIcon(new ImageIcon(PREDICTIONPIC).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT));

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
    private JButton backButton;
    private JButton documentationButton;
    private JButton faqButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel westPanel;
    //JLabel
    private JLabel messageFLabel;
    //Picture JLabel
    private JLabel homeLabel;
    private JLabel dataLabel;
    private JLabel inputLabel;
    private JLabel rankLabel;
    private JLabel newDishLabel;
    private JLabel predictionLabel;
    private JLabel ratioLabel;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();
    //Documentation of different functionsprivate 
    String[] optionName =
    {
        "Home", "New Dish", "Data", "Input", "Rank", "Ratio", "Prediction"
    };
    private JComboBox viewOption;

    public Help()
    {
        super("Help");
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
        //Bottom panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 50, 20, 50);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);
        //Center Panel 
        this.documentationButton = new JButton("Documentation");
        documentationButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(documentationButton, gbc);
        this.faqButton = new JButton("FAQ");
        faqButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(faqButton, gbc);
        //Selection for documentation of each function
        this.viewOption = new JComboBox(optionName);
        viewOption.addActionListener(this);
        // During update process
        this.messageFLabel = new JLabel("Developers are gathering data and questions from user to develop this function.");
        this.backButton = new JButton("Back");
        backButton.addActionListener(this);
        //Putting Picture into Label
        this.homeLabel = new JLabel(HOME_PIC);
        this.dataLabel = new JLabel(DATA_PIC);
        this.newDishLabel = new JLabel(NEWDISH_PIC);
        this.inputLabel = new JLabel(INPUT_PIC);
        this.rankLabel = new JLabel(RANK_PIC);
        this.predictionLabel = new JLabel(PREDICTION_PIC);
        this.ratioLabel = new JLabel(RATIO_PIC);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //Close the Frame
        if (command.equals("Close"))
        {
            this.dispose();
        } //Close this frame and open a new help frame
        else if (command.equals("Help"))
        {
            this.dispose();
            Help objHelp = new Help();
        } 
        //reset the frame
        else if (command.equals("Back"))
        {
            this.dispose();
            new Help();
        }
        //View documentation 
        else if (command.equals("Documentation"))
        {
            //Add into bottom Panel a return button
            gbc.gridx = 1;
            gbc.gridy = 0;
            lowerPanel.add(backButton);
            //Reset Panel
            westPanel.removeAll();
            centerPanel.removeAll();
            //add WestPanel
            this.add(westPanel, BorderLayout.WEST);
            westPanel.add(viewOption);
            //Default view for documentation
            centerPanel.add(homeLabel);

        } //view Frequently asked question
        else if (command.equals("FAQ"))
        {
            centerPanel.removeAll();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridx = 0;
            gbc.gridy = 1;
            centerPanel.add(backButton);
            centerPanel.add(messageFLabel);
        }
        else if (e.getSource() == viewOption)
        {
            JComboBox cb = (JComboBox) e.getSource();
            String picture = (String) cb.getSelectedItem();
            //Home picture
            if (picture.equals("Home"))
            {
                centerPanel.removeAll();
                centerPanel.add(homeLabel);
            }
            //Data picture
            else if (picture.equals("Data"))
            {
                centerPanel.removeAll();
                centerPanel.add(dataLabel);
            }
            //New dish picture
            else if (picture.equals("New Dish"))
            {
                centerPanel.removeAll();
                centerPanel.add(newDishLabel);
            }
            //Input picture
            else if (picture.equals("Input"))
            {
                centerPanel.removeAll();
                centerPanel.add(inputLabel);
            }
            //Rank picture
            else if (picture.equals("Rank"))
            {
                centerPanel.removeAll();
                centerPanel.add(rankLabel);
            }
            //Ratio picture
            else if (picture.equals("Ratio"))
            {
                centerPanel.removeAll();
                centerPanel.add(ratioLabel);
            }
            //Prediction picture
            else if (picture.equals("Prediction"))
            {
                centerPanel.removeAll();
                centerPanel.add(predictionLabel);
            }
        }
        this.validate();
        this.repaint();
    }

    //Main method for testing
    public static void main(String args[])
    {
        Help objHelp = new Help();
    }
}
