package service.assistants;

import service.dispatcher.DispatcherNotebook;
import service.dispatcher.conveyor.ConveyorImpl;
import service.dispatcher.DispatcherDesktop;
import service.dispatcher.DispatcherInterface;
import service.dispatcher.DispatcherMonitor;
import view.MenuPrincipal;
import view.center.mainPane.ActPaneImpl;

import view.center.panes.AltPaneDesktop;

import view.center.panes.AltPaneInterface;
import view.center.panes.AltPaneMonitor;
import view.center.panes.AltPaneNotebook;
import view.requierements.ComponentsRequierementsImpl;

import javax.swing.*;
import java.awt.*;


public class AssistantsMethodsImpl implements AssistantsMethodInterface {

    ActPaneImpl actPane = new ActPaneImpl();
    @Override
    public void switcher() {
        ActPaneImpl.actPane.setVisible(false);
    }
    
    @Override
    public void changerMainFrameCenterLayout(AltPaneInterface altPaneInterface, DispatcherInterface dispatcherInterface) {
        MenuPrincipal.mainFrame.add(
                actPane.actPanel(true,
                        altPaneInterface,
                new ConveyorImpl( dispatcherInterface )),
                BorderLayout.CENTER);

        MenuPrincipal.mainFrame.pack();
    }



    @Override
    public void changerMainFrameCenterLayoutTipoComboBox() {
        switch (catchValueComboBox(ComponentsRequierementsImpl.cbTipoEquipamento)) {
            case "Monitor" :
                switcher();
                changerMainFrameCenterLayout(new AltPaneMonitor(), new DispatcherMonitor());
                break;

            case "Desktop" :
                switcher();
                changerMainFrameCenterLayout(new AltPaneDesktop(), new DispatcherDesktop());
                break;

            case "Notebook" :
                switcher();
                changerMainFrameCenterLayout(new AltPaneNotebook(), new DispatcherNotebook());
                break;

            default:
                JOptionPane.showMessageDialog(null,"OK");
        }
    }

    @Override
    public String catchValueComboBox(JComboBox jComboBox) {
        return String.valueOf(
                jComboBox.
                        getSelectedItem());
    }


}
