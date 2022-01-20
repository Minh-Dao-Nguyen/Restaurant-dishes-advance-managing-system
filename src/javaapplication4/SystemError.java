/*
Spetember 21st 2020
 * This is GUI class. This frame tells the user that there is an error occur within the system.
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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class SystemError extends JFrame implements ActionListener
{
    //COlor
    public static final Color WHITE = new Color(255,255,255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color SLIVER = new Color(192, 192, 192);
    //Menu bar
    private JMenuBar mainBar;
    private JMenu moreMenu;
    private JMenuItem helpMenu;
    //JButton
    private JButton homeButton;
    private JButton closeButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    //JPanel
    private JLabel errorLabel;

    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    public SystemError(String messageLabel)
    {
        super("System Error");
        this.setBounds(500, 100, 500, 300);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        gbc.insets = new Insets(20, 50, 20, 50);
        this.closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.homeButton = new JButton("Ok");
        homeButton.addActionListener(this);
        lowerPanel.add(homeButton, gbc);
        //CenterPanel
        this.errorLabel = new JLabel(messageLabel);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(errorLabel, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //closeing the system 
        if (command.equals("Close"))
        {
            WarningClose objWawrning = new WarningClose();
        } 
        //close the frame
        else if (command.equals("Ok"))
        {
            this.dispose();
        } 
        //open help frame
        else if (command.equals("Help"))
        {
            Help objHelp = new Help();
        }
        this.validate();
        this.repaint();
    }
    //Main method for testing
    public static void main(String args[])
    {
        String messageError = "There is an Error occure";
        SystemError objSystemError = new SystemError(messageError);
    }
}
