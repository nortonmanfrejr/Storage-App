package view.center.panes;

import service.dispatcher.conveyor.ConveyorInterface;

import javax.swing.*;

public interface AltPaneInterface {


    JPanel northTitle();
    JPanel centerField();
    JPanel eastButton(ConveyorInterface conveyorInterface);
    JScrollPane southTable();
}
