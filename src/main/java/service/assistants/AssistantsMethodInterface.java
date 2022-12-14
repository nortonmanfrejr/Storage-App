package service.assistants;

import service.dispatcher.DispatcherInterface;
import view.center.panes.AltPaneInterface;

import javax.swing.*;

public interface AssistantsMethodInterface {

    void switcher();
    void changerMainFrameCenterLayout(AltPaneInterface altPaneInterface, DispatcherInterface dispatcherInterface);
    void changerMainFrameCenterLayoutTipoComboBox();
    String catchValueComboBox(JComboBox jComboBox);
}
