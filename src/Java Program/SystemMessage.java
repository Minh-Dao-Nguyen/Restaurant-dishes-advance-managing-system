/*
September 21st 2020
This GUI class displayed system message such as "sucessfully input" to let the user know 
that what he or she asked or did have sucessfully executred. 
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


public class SystemMessage extends JFrame implements ActionListener
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
    //JLabel
    private JLabel errorLabel;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    public SystemMessage(String message)
    {
        //frame size
        super("System");
        this.setBounds(200, 100, 400, 200);

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
        this.closeButton = new JButton("ok");
        closeButton.addActionListener(this);
        lowerPanel.add(closeButton, gbc);  
        //CenterPanel
        this.errorLabel = new JLabel(message);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(errorLabel, gbc);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //Closing the frame
         if (command.equals("ok"))
        {
            this.dispose();
        }
        //Opening help frame
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
        UserError objUserError = new UserError("Test");
    }
}
