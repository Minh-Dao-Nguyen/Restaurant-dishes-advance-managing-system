/*
September 20th 2020
This is a GUI class that warn the user that he or she is closing the program. It prevents user from closing
the application by accident. 
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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WarningClose extends JFrame implements ActionListener
{
    //Color
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color SLIVER = new Color(192, 192, 192);
    //JButton
    private JButton yesButton;
    private JButton noButton;
    //JPanel
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    //JLabel
    private JLabel messageLabel;
    //Gridlayout
    GridBagConstraints gbc = new GridBagConstraints();

    public WarningClose()
    {
        //frame size
        super("System");
        this.setBounds(250, 250, 400, 200);

        //Panel
        //center Panel 
        this.centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(WHITE);
        this.add(centerPanel, BorderLayout.CENTER);
        //top Panel
        this.upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBackground(GRAY);
        this.add(upperPanel, BorderLayout.NORTH);
        //bottom Panel
        this.lowerPanel = new JPanel(new GridBagLayout());
        lowerPanel.setBackground(GRAY);
        this.add(lowerPanel, BorderLayout.SOUTH);
        //Bottom panel
        //adding "Yes" Button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 50, 20, 50);
        this.yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        lowerPanel.add(yesButton, gbc);
        //Adding "No" Button
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.noButton = new JButton("No");
        noButton.addActionListener(this);
        lowerPanel.add(noButton, gbc);
        //CenterPanel
        //Add the system message
        String message = "Are you sure you want to quit ?";
        this.messageLabel = new JLabel(message);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(messageLabel, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //The user doesn't want to close the program 
        if (command.equals("No"))
        {
            this.dispose();
        } 
        //The user want to close the program 
        else if (command.equals("Yes"))
        {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    //Main methof for testing
    public static void main(String args[])
    {
        WarningClose objWarning = new WarningClose();
    }
}
