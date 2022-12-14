package view.west;


import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

@NoArgsConstructor
public class WestImpl implements West {

    JPanel panel;

    public JPanel west(Component... components) {
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(5,10,5,5));

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < components.length; i++) {

            c.ipady = 4;
            c.weighty = 1.0;
            c.anchor = GridBagConstraints.CENTER;
            c.insets = new Insets(5,0,5,0);
            c.gridx = 0;
            c.gridwidth = 2;
            c.gridy = i;

            panel.add(components[i], c);
        }

        return panel;
    }

}
