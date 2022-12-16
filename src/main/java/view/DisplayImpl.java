package view;

import view.requierements.FieldAssistant;

import javax.swing.*;
import java.awt.*;

public class DisplayImpl {

    private JFrame display;
    private JPanel templateDisplay, templateButton;
    private JLabel lbMsg;
    private JButton btnYes,btnNo,btnOk;
    private boolean ANSWER;
    private final FieldAssistant gridConstraint = new FieldAssistant();

    public void displayWithOk(String mensagem) {
        display = new JFrame("Atenção");

        lbMsg = new JLabel(mensagem);

        btnOk = new JButton("Ok");
        btnOk.setPreferredSize(new Dimension(100,25));
        btnOk.setMinimumSize(new Dimension(100,25));
        btnOk.addActionListener(e -> display.dispose());

        templateDisplay = new JPanel(new GridBagLayout());
        templateDisplay.add(lbMsg, gridConstraint.fieldConstraints(0,0));
        templateDisplay.add(btnOk, gridConstraint.fieldConstraints(0,1));

        display.add(templateDisplay);
        display.pack();
        display.setLocationRelativeTo(null);
        display.setVisible(true);
    }

    public boolean displayWithYesNo(String mensagem) {
        display = new JFrame("Tem certeza?");

        lbMsg = new JLabel(mensagem);

        templateDisplay = new JPanel(new GridBagLayout());
        templateDisplay.add(lbMsg, gridConstraint.fieldConstraints(0,0));
        templateDisplay.add(setButton(), gridConstraint.fieldConstraints(0,1));

        display.add(templateDisplay);
        display.pack();
        display.setLocationRelativeTo(null);
        display.setVisible(true);

        return ANSWER;
    }

    private boolean setAnswer(boolean answer) {
        this.ANSWER = answer;
        display.dispose();
        return ANSWER;
    }

    private JPanel setButton() {
        btnYes = new JButton("Sim");
        btnYes.setPreferredSize(new Dimension(100,25));
        btnYes.setMinimumSize(new Dimension(100,25));
        btnYes.addActionListener(e -> {
            ANSWER = true;
            display.dispose();
        });

        btnNo = new JButton("Não");
        btnNo.setPreferredSize(new Dimension(100,25));
        btnNo.setMinimumSize(new Dimension(100,25));
        btnNo.addActionListener(e -> setAnswer(false));

        templateButton = new JPanel(new GridBagLayout());
        templateButton.add(btnYes, gridConstraint.fieldConstraints(0,0));
        templateButton.add(btnNo, gridConstraint.fieldConstraints(1,0));

        return templateButton;
    }
}
