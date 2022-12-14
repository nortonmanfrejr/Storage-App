package view.center.panes;

import model.abstractTableModel.EquipamentoTBModel;
import service.dispatcher.DispatcherEquipamento;
import service.dispatcher.conveyor.ConveyorImpl;
import service.dispatcher.conveyor.ConveyorInterface;

import javax.swing.*;
import java.awt.*;

public class AltPaneHome implements AltPaneInterface {

    ConveyorInterface conveyorInterface = new ConveyorImpl(new DispatcherEquipamento());
    @Override
    public JPanel northTitle() {
        JLabel tituloPagina = new JLabel("Daddy Storage - Menu Principal");
        tituloPagina.setFont(new Font("Tahoma",Font.BOLD,34));

        JPanel p = new JPanel();
        p.add(tituloPagina);
        p.setBorder(BorderFactory.createBevelBorder(0));

        return p;
    }

    @Override
    public JPanel centerField() {
        return new JPanel();
    }

    @Override
    public JPanel eastButton(ConveyorInterface conveyorInterface) {
        JPanel jPanel = new JPanel();
        jPanel.add(northTitle());

        jPanel.setMinimumSize(new Dimension(300,250));

        return jPanel;
    }

    @Override
    public JScrollPane southTable() {
        JTable table = new JTable(new EquipamentoTBModel(conveyorInterface.read()));

        JScrollPane southPanel = new JScrollPane(table);
        southPanel.setPreferredSize(new Dimension(400,300));

        return southPanel;
    }
}
