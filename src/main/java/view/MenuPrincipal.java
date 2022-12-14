package view;

import lombok.NoArgsConstructor;

import service.assistants.AssistantsMethodInterface;
import service.assistants.AssistantsMethodsImpl;
import service.dispatcher.conveyor.ConveyorImpl;
import service.dispatcher.DispatcherEquipamento;
import view.center.mainPane.ActPaneImpl;
import view.center.mainPane.CenterPaneInterface;
import view.center.panes.AltPaneDesktop;
import view.center.panes.AltPaneHome;
import view.requierements.FieldsRequierement;
import view.requierements.ComponentsRequierementsImpl;
import view.west.West;
import view.west.WestImpl;

import javax.swing.*;
import java.awt.*;

@NoArgsConstructor
public class MenuPrincipal implements ViewInterface{

    public static JFrame mainFrame;

    FieldsRequierement f = new ComponentsRequierementsImpl();
    CenterPaneInterface act = new ActPaneImpl();
    AssistantsMethodInterface assistantsMethodInterface = new AssistantsMethodsImpl();
    West west = new WestImpl();

    @Override
    public void initComponents() {
        mainFrame = new JFrame("Daddy Storage");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout(5,5));

        mainFrame.add(west.west(
                f.factoryJButton("Home",
                        e -> {
                    assistantsMethodInterface.switcher();
                    assistantsMethodInterface.changerMainFrameCenterLayout(new AltPaneHome(),new DispatcherEquipamento());
                        }),


                f.cb_tipoEquipamento(
                        "Monitor",
                        "Desktop",
                        "Notebook"
                ), f.factoryJButton("Encerrar", e -> mainFrame.dispose()), espacoBranco()

        ), BorderLayout.WEST);

        mainFrame.add(
                act.actPanel(
                        true,
                        new AltPaneHome(),
                        new ConveyorImpl(new DispatcherEquipamento())),
                BorderLayout.CENTER);


        mainFrame.setMinimumSize(new Dimension(1288,756));

        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private JPanel espacoBranco() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,550));
        return panel;
    }
}
