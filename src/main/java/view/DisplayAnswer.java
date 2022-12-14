package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAnswer extends JDialog implements ActionListener {


    private JPanel messagePane = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton confirm = new JButton("Confirm");
    private JButton deny = new JButton("Deny");
    private JButton ok = new JButton("Ok...");
    private JLabel messageLabel = new JLabel();

    private Boolean answer = false;
    private String message;

    public DisplayAnswer() {
        super(MenuPrincipal.mainFrame, "Ooops...");
    }

    public boolean displayAnswer(String message) {
        this.messageLabel = new JLabel(message);

        messagePane.add(messageLabel);
        getContentPane().add(messagePane);

        buttonPanel.add(confirm);
        buttonPanel.add(deny);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);


        confirm.addActionListener(this);
        deny.addActionListener(this);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        pack();
        setResizable(false);
        setVisible(true);

        return answer;
    }

    public void confirmDisplay(String message) {
        this.messageLabel = new JLabel(message);

        messagePane.add(messageLabel);
        getContentPane().add(messagePane);

        buttonPanel.add(ok);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

        ok.addActionListener(e -> dispose());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(deny)) {
            dispose();
        }
        if (source.equals(confirm)) {
            answer = true;
            dispose();
        }
    }

}
