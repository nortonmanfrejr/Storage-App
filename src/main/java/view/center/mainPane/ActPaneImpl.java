package view.center.mainPane;

import service.dispatcher.conveyor.ConveyorInterface;
import view.center.panes.AltPaneInterface;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ActPaneImpl implements CenterPaneInterface{
    public static JPanel actPane;

    @Override
    public JPanel actPanel(Boolean turnOn,
                           AltPaneInterface alternativePane,
                           ConveyorInterface conveyorInterface ) {

        actPane = new JPanel();

        actPane.setLayout(new BorderLayout());

        actPane.add(alternativePane.northTitle(), BorderLayout.NORTH);
        actPane.add(alternativePane.centerField(), BorderLayout.CENTER);
        actPane.add(alternativePane.southTable(),BorderLayout.SOUTH);
        actPane.add(alternativePane.eastButton(conveyorInterface),BorderLayout.EAST);

        actPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        actPane.setVisible(turnOn);

        return actPane;
    }

}
