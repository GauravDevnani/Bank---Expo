package atm.stimulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pinnumber;

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);

        // Set bounds for labels and buttons
        l1.setBounds(220, 300, 400, 35);
        l2.add(l1);

        b1.setBounds(160, 400, 150, 35);
        l2.add(b1);

        b2.setBounds(365, 400, 150, 35);
        l2.add(b2);

        b3.setBounds(162, 450, 150, 35);
        l2.add(b3);

        b4.setBounds(365, 450, 150, 35);
        l2.add(b4);

        b5.setBounds(160, 500, 150, 35);
        l2.add(b5);

        b6.setBounds(365, 500, 150, 35);
        l2.add(b6);

        b7.setBounds(225, 580, 200, 35);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (e.getSource() == b3) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (e.getSource() == b4) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (e.getSource() == b5) {
            setVisible(false);
            new Pin(pinnumber).setVisible(true);
        } else if (e.getSource() == b6) {
            this.setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (e.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}

