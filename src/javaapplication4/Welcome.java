/*
Spetember 20th 2020
 * This class is GUI of the first frame when the program is run. 
 */
//package internalassesment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Welcome extends JFrame implements ActionListener
{
    //Color
    public static final Color WHITE = new Color(255,255,255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color SLIVER = new Color(192, 192, 192);
    private final URL PIC_FONT = getClass().getResource("WelcomePicture.jpg");
    private final ImageIcon PIC
            = new ImageIcon(new ImageIcon(PIC_FONT).getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT)); 
    //Menu bar
    private JMenuBar mainBar;
    private JMenu moreMenu;
    private JMenuItem helpMenu;
    //JLabel
    private JLabel nameLabel;
    private JLabel picLabel;
    //JButton
    private JButton homeButton;
    private JButton helpButton;
    private JButton closeButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();


    public Welcome()
    {
        //Side of the windows
        super("Welcome");
        this.setBounds(100, 100, 900, 700);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //buttons
        this.homeButton = new JButton("Home");
        homeButton.addActionListener(this);
        homeButton.setBounds(10, 10, 10, 5);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        //label
        this.nameLabel = new JLabel("FoodCourses");
        this.picLabel = new JLabel(PIC);
        //panels
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        this.lowerPanel = new JPanel( new FlowLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        
        //add buttons to Panel
        //name of the program 
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(nameLabel, gbc);
        //picture
        gbc.gridy = 1;
        centerPanel.add(picLabel, gbc);
        //Adding home buttons
        gbc.gridy = 2;
        centerPanel.add(homeButton, gbc);
        //Adding close Buttom to bottom Panel 
        lowerPanel.add(closeButton);

        //Menu
        this.mainBar = new JMenuBar();
        mainBar.setBackground(GRAY);
        this.moreMenu = new JMenu("More");
        this.helpMenu = new JMenuItem("Help");
        helpMenu.addActionListener(this);
        moreMenu.add(helpMenu);
        mainBar.add(moreMenu);
        this.setJMenuBar(mainBar);
        
       
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //Closing the program
        if (command.equals("Close"))
        {
            WarningClose objWarning = new WarningClose();
        }
        //Open help frame
        else if (command.equals("Help"))
        {
            Help objHelp = new Help();
        }
        //Open Home Frame
        else if(command.equals("Home"))
        {
            this.dispose();
            Home objHome = new Home();
        }
        this.validate();
        this.repaint();
    }
    //Main method for testing
    public static void main(String[] args)
    {
        Welcome objWelcome = new Welcome();
    }
}
