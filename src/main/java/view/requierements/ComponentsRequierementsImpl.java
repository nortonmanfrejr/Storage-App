package view.requierements;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ComponentsRequierementsImpl
        extends StaticFieldRequierementsVar
        implements FieldsRequierement {



    @Override
    public JButton factoryJButton(String buttonText, ActionListener action){
        JButton button = new JButton(buttonText);

        button.addActionListener(action);
        componentPreferredSize(button,100,25);

        return button;
    }

    @Override
    public JTextField txf_patrimonio() {
        txfPatrimonio = new JTextField("Patrimonio");

        txfPatrimonio.setToolTipText("Insira o patrimonio do equipamento sem a letra inicial, exempo: 023780");
        componentPreferredSize(txfPatrimonio,100,25);
        clearTextFieldsMouseEventAfterClick(txfPatrimonio);

       return txfPatrimonio;
    }

    @Override
    public JTextField txf_servicetag() {
        txfServiceTag = new JTextField("Service Tag");

        txfServiceTag.setToolTipText("Caso o equipamento não tenha um patrimonio utilize o Service Tag como um identificador alternativo, exemplo: H87Q9R2");
        componentPreferredSize(txfServiceTag,100,25);
        clearTextFieldsMouseEventAfterClick(txfServiceTag);

       return txfServiceTag;
    }

    @Override
    public JTextField txf_macAdress() {
        txfMacAdress = new JTextField("Mac Adress");

        txfMacAdress.setToolTipText("O macAdress é um identificador alternativo também, caso a máquina não tenha Service Tag e/ou Patrimonio, utilize este campo (Disponivel apenas para Desktop e Notebook).");
        componentPreferredSize(txfMacAdress,100,25);
        clearTextFieldsMouseEventAfterClick(txfMacAdress);

        return txfMacAdress;
   }

    @Override
    public JTextArea txa_observacao() {
        txaObersevacao = new JTextArea("Insira as observação sobre o equipamento aqui...");

        txaObersevacao.setBorder(BorderFactory.createBevelBorder(1));
        txaObersevacao.setLineWrap(true);

        txaObersevacao.setToolTipText("Observações sobre o equipamento, caso esteja danificado, reservado e/ou algum histórico de usuario a ser relatado.");
        componentPreferredSize(txaObersevacao, 100,50);
        clearTextFieldsMouseEventAfterClick(txaObersevacao);

        return txaObersevacao;
    }

    @Override
    public JComboBox<String> cb_marca() {
        cbMarca = new JComboBox<>();

        cbMarca.setToolTipText("Marca a qual o produto pertence, caso não esteja listada somente digitar a nova e sera automaticamente listada.");
        setEditableInComboBox(cbMarca);
        componentPreferredSize(cbMarca,100,25);

        setModelInComboBox(
                cbMarca,
                "SELECT * FROM tbequipamento WHERE tipoEquipamento = ?",
                "marca",

                services.catchValueComboBox(cbTipoEquipamento)
        );

        cbMarca.addActionListener(action -> {

            setModelInComboBox(
                    cbModelo,
                    "SELECT * FROM tbequipamento WHERE tipoEquipamento = ? AND marca = ?",
                    "modelo",

                    services.catchValueComboBox(cbTipoEquipamento),
                    services.catchValueComboBox(cbMarca)
            );
        });

        return cbMarca;
    }

    @Override
    public JComboBox<String> cb_modelo() {
        cbModelo = new JComboBox<>();

        cbModelo.setToolTipText("Modelo do produto, caso não esteja listado somente digitar o novo e sera automaticamente listado.");
        setEditableInComboBox(cbModelo);
        componentPreferredSize(cbModelo,100,25);

        return cbModelo;
   }

    @Override
    public JComboBox<String> cb_status(String... args) {
        cbStatus = new JComboBox<>();

        cbStatus.setToolTipText("Status do equipamento ( Ativo, Sucata, Manutenção, Emprestado )");
        componentPreferredSize(cbStatus,100,25);

        for (String arg : args) cbStatus.addItem(arg);

        return cbStatus;
    }

    @Override
    public JComboBox<String> cb_disponibilidadeEmprestimo() {
        cbDisponibilidadeEmprestimo = new JComboBox<>();

        cbDisponibilidadeEmprestimo.setToolTipText("O equipamento a ser adicionado tem disponibilidade para ser emprestado ( Em especifico notebooks e cameras ).");
        componentPreferredSize(cbDisponibilidadeEmprestimo,100,25);

        cbDisponibilidadeEmprestimo.addItem("Não");
        cbDisponibilidadeEmprestimo.addItem("Sim");

        return cbDisponibilidadeEmprestimo;
   }


    @Override
    public JComboBox<String> cb_andar() {
        cbAndar = new JComboBox<>();

        cbAndar.setToolTipText("Andar onde o equipamento se encontra.");
        componentPreferredSize(cbAndar,100,25);

        setModelInComboBox(
                cbAndar,
                "SELECT * FROM tbambiente",
                "andar"
        );

        cbAndar.addActionListener(action -> {

            cbDepartamento.removeAll();
            cbSetor.removeAll();

            setModelInComboBox(
                    cbDepartamento,
                    "SELECT * FROM tbambiente WHERE andar = ?",
                    "departamento",

                    services.catchValueComboBox(cbAndar)
            );
        });

        return cbAndar;
    }


    @Override
    public JComboBox<String> cb_departamento() {
        cbDepartamento = new JComboBox<>();

        cbDepartamento.setToolTipText("Departamento onde o equipamento se encontra, a filtragem ocorre de acordo com o Andar.");
        componentPreferredSize(cbDepartamento,100,25);

        cbDepartamento.addActionListener(action -> {

            cbSetor.removeAll();

            setModelInComboBox(
                    cbSetor,
                    "SELECT * FROM tbambiente WHERE andar = ? AND departamento = ?",
                    "setor",

                    services.catchValueComboBox(cbAndar),
                    services.catchValueComboBox(cbDepartamento)
            );
        });

        return cbDepartamento;
    }

    @Override
    public JComboBox<String> cb_setor() {
        cbSetor = new JComboBox<>();

        cbSetor.setToolTipText("Setor onde o equipamento se encontra, a filtragem ocorre de acordo com o Departamento.");
        componentPreferredSize(cbSetor,100,25);

        return cbSetor;
   }

    @Override
    public JComboBox<String> cb_ajustabilidadeMonitor(String... args) {
        cbAjustabilidadeMonitor = new JComboBox<>();

        cbAjustabilidadeMonitor.setToolTipText("O monitor é ajustavel)?");
        componentPreferredSize(cbAjustabilidadeMonitor,100,25);

        for (String arg : args) cbAjustabilidadeMonitor.addItem(arg);

        return cbAjustabilidadeMonitor;
    }

    @Override
    public JComboBox<String> cb_tipoArmazenamento() {
        cbTipoArmazenamento = new JComboBox<>();

        cbTipoArmazenamento.setToolTipText("Tipo de Armazenamento (HDD ou SSD) aconselhavel que coloque seus tamanho em GBs tambem, caso não esteja listado somente digitar o novo e sera automaticamente listado.");
        setEditableInComboBox(cbTipoArmazenamento);
        componentPreferredSize(cbTipoArmazenamento,100,25);

        setModelInComboBox(
                cbTipoArmazenamento,
                "SELECT * FROM tbmaquina",
                "armazenamento"
        );

        return cbTipoArmazenamento;
    }

    @Override
    public JComboBox<String> cb_placaDeVideo() {
        cbPlacaDeVideo = new JComboBox<>();

        cbPlacaDeVideo.setToolTipText("Placa de video da maquina, caso não esteja listado somente digitar o novo e sera automaticamente listado.");
        setEditableInComboBox(cbPlacaDeVideo);
        componentPreferredSize(cbPlacaDeVideo,100,25);

        setModelInComboBox(
                cbPlacaDeVideo,
                "SELECT * FROM tbmaquina",
                "gpu"
        );

        return cbPlacaDeVideo;
    }

    @Override
    public JComboBox<String> cb_sistemaOperacional() {
        cbSistemaOperacional = new JComboBox<>();
        cbSistemaOperacional.setToolTipText("Sistema Operacional da maquina, caso não esteja listado somente digitar o novo e sera automaticamente listado.");
        setEditableInComboBox(cbSistemaOperacional);
        componentPreferredSize(cbSistemaOperacional,100,25);

        setModelInComboBox(
                cbSistemaOperacional,
                "SELECT * FROM tbmaquina",
                "sistemaOperacional"
        );

       return cbSistemaOperacional;
    }

    @Override
    public JComboBox<String> cb_memoriaRAM() {
        cbMemoriaRam = new JComboBox<>();

        cbMemoriaRam.setToolTipText("Memoria RAM do equipamento aconselhavel que insira o seu tamanho em GBs tambem, caso não esteja listado somente digitar o novo e sera automaticamente listado.");
        setEditableInComboBox(cbMemoriaRam);
        componentPreferredSize(cbMemoriaRam,100,25);

        setModelInComboBox(
                cbMemoriaRam,
                "SELECT * FROM tbmaquina",
                "memoriaRAM"
        );

        return cbMemoriaRam;
    }

    @Override
    public JComboBox<String> cb_tipoEquipamento(String... tipos) {
        cbTipoEquipamento = new JComboBox<>();

        cbTipoEquipamento.setToolTipText("Alterna entra as janelas de operação da aplicação.");
        componentPreferredSize(cbTipoEquipamento,100,25);

        for (String arg : tipos) cbTipoEquipamento.addItem(arg);

        cbTipoEquipamento.addActionListener(e -> services.changerMainFrameCenterLayoutTipoComboBox());

        return cbTipoEquipamento;
    }

    @Override
    public JTextField txf_campoDeBusca() {
        txf_campoDeBusca = new JTextField("Buscar equipamento");

        txf_campoDeBusca.setToolTipText("Digite o Identificador do equipamento desejado.");
        clearTextFieldsMouseEventAfterClick(txf_campoDeBusca);

        return txf_campoDeBusca;
    }
}
