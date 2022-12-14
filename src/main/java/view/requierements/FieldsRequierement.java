package view.requierements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface FieldsRequierement {


    JButton factoryJButton(String buttonText, ActionListener action);

    JTextField txf_patrimonio();
    JTextField txf_servicetag();
    JTextField txf_macAdress();

    JTextArea txa_observacao();

    JComboBox<String> cb_marca();
    JComboBox<String> cb_modelo();
    JComboBox<String> cb_status(String... args);
    JComboBox<String> cb_disponibilidadeEmprestimo();

    JComboBox<String> cb_andar();
    JComboBox<String> cb_departamento();
    JComboBox<String> cb_setor();

    JComboBox<String> cb_ajustabilidadeMonitor(String... args);

    JComboBox<String> cb_tipoArmazenamento();
    JComboBox<String> cb_placaDeVideo();
    JComboBox<String> cb_sistemaOperacional();
    JComboBox<String> cb_memoriaRAM();

    JComboBox<String> cb_tipoEquipamento(String... tipos);

    JTextField txf_campoDeBusca();


}