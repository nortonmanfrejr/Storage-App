package view.center.mainPane;

import service.dispatcher.conveyor.ConveyorInterface;
import view.center.panes.AltPaneInterface;

import javax.swing.*;

public interface CenterPaneInterface {

    JPanel actPanel(Boolean turnOn,
                    AltPaneInterface alternativePane,
                    ConveyorInterface conveyorInterface);
}
