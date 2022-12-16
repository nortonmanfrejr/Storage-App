package view.requierements;

import model.jComboBoxModel.CBoxModel;
import model.jComboBoxModel.ComboBoxModelInterface;
import service.assistants.AssistantsMethodInterface;
import service.assistants.AssistantsMethodsImpl;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FieldAssistant {

    AssistantsMethodInterface services = new AssistantsMethodsImpl();
    ComboBoxModelInterface comboBoxData = new CBoxModel();


    public void clearTextFieldsMouseEventAfterClick(JTextComponent textField) {
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String defaultText = textField.getText();
                textField.setText((defaultText.equals(textField.getText())? "" : defaultText));
            }
        });

    }

    public void componentPreferredSize(Component component, int widht, int height) {
        component.setPreferredSize(new Dimension(widht,height));
    }

    public void setModelInComboBox(JComboBox component, String sql, String col, String... whereJComboBoxReference) {
        DefaultComboBoxModel modeloComboBox;


        modeloComboBox = new DefaultComboBoxModel(
                comboBoxData.dataListForJCBModel(
                                sql,
                                col,

                                whereJComboBoxReference
                        ).
                        toArray()
        );

        component.setModel(modeloComboBox);
    }

    public void setEditableInComboBox(JComboBox component) {
        component.setEditable(true);
    }

    public JPanel boxLayoutHorizontalWithLabel(String str, Component component) {
        JPanel horizontalBox = new JPanel();
        horizontalBox.setLayout(new BoxLayout(horizontalBox, BoxLayout.X_AXIS));

        JLabel nomeCampo = new JLabel();
        nomeCampo.setText(str);
        nomeCampo.setFont(new Font("Tahoma",Font.BOLD,12));

        horizontalBox.add(nomeCampo);
        horizontalBox.add(Box.createRigidArea(new Dimension(5,0)));

        horizontalBox.add(component);

        return horizontalBox;
    }

    public GridBagConstraints fieldConstraints(int... gridValue){

        GridBagConstraints c = new GridBagConstraints();

        c.ipady = 4;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.gridx = gridValue[0];
        c.gridy = gridValue[1];

        return c;
    }

    public void addComponentIntoPaneIfGridPane(JPanel referencePanel,String componentLabel, JComponent component, int... gridXY) {
        referencePanel.add(
                boxLayoutHorizontalWithLabel(componentLabel, component),
                fieldConstraints(gridXY[0],gridXY[1])
        );
    }
    public void addComponentIntoGridPaneNoLabel(JPanel referencePanel,JComponent component, int... gridXY) {
        referencePanel.add(
                component,
                fieldConstraints(gridXY[0],gridXY[1])
        );
    }

}
