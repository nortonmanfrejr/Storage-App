package service.dispatcher;

import model.objectModel.Maquina;
import repository.receiver.ReceiverImpl;
import repository.receiver.ReceiverInterface;
import view.requierements.ComponentsRequierementsImpl;
import view.requierements.StaticFieldRequierementsVar;

import java.util.List;

public class DispatcherNotebook implements DispatcherInterface {

    private final String sqlInsert = "INSERT INTO tbmaquina " +
            "( armazenamento, memoriaRAM, gpu, sistemaOperacional, enderecoMAC, fk_equipamentoID) " +
            "VALUES ( ?,?,?,?,?,?)";
    private final String sqlRead = "select " +
            "m.armazenamento, " +
            "m.memoriaRAM, " +
            "m.gpu, " +
            "m.sistemaOperacional, " +
            "m.enderecoMAC, " +
            "e.disponibilidadeEmprestimo, " +
            "e.tipoEquipamento, " +
            "e.patrimonio, " +
            "e.servicetag, " +
            "e.marca, " +
            "e.modelo, " +
            "a.andar, " +
            "a.departamento, " +
            "a.setor, " +
            "e.observacao, " +
            "e.status from tbmaquina m " +
            "inner join tbequipamento e on m.fk_equipamentoID = e.equipamentoID and e.tipoEquipamento = 'Notebook' " +
            "inner join tbambiente a on e.fk_ambienteID = a.ambienteID " ;
    private final String sqlSearch = "select " +
            "m.armazenamento, " +
            "m.memoriaRAM, " +
            "m.gpu, " +
            "m.sistemaOperacional, " +
            "m.enderecoMAC, " +
            "e.disponibilidadeEmprestimo, " +
            "e.tipoEquipamento, " +
            "e.patrimonio, " +
            "e.servicetag, " +
            "e.marca, " +
            "e.modelo, " +
            "a.andar, " +
            "a.departamento, " +
            "a.setor, " +
            "e.observacao, " +
            "e.status from tbmaquina m " +
            "inner join tbequipamento e on m.fk_equipamentoID = e.equipamentoID AND e.tipoEquipamento = 'Notebook' " +
            "inner join tbambiente a on e.fk_ambienteID = a.ambienteID " +
            "WHERE e.patrimonio = ? OR e.servicetag = ?";
    private final String sqlDelete = "DELETE desktop " +
            "FROM tbmaquina AS desktop " +
            "INNER JOIN tbequipamento AS equipamento " +
            "ON desktop.fk_equipamentoID = equipamento.equipamentoID AND equipamento.tipoEquipamento = 'Notebook' " +
            "WHERE equipamento.patrimonio = ? " +
            "OR equipamento.servicetag = ?";
    private final String sqlUpdate = "UPDATE tbmaquina " +
            "SET maquina.armazenamento = ?, maquina.memoriaRAM = ?, maquina.gpu = ?, maquina.sistemaOperacional = ? " +
            "FROM tbmaquina AS maquina " +
            "INNER JOIN tbequipamento equipamento ON maquina.fk_equipamentoID = equipamento.equipamentoID AND equipamento.tipoEquipamento = 'Notebook'" +
            "WHERE equipamento.patrimonio = ? OR equipamento.servicetag = ?";
    private final ReceiverInterface receiverInterface = new ReceiverImpl(new Maquina());


    @Override
    public void valueForInsert() {
        receiverInterface.comunicationSqlCommandIUD(
                sqlInsert,

                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbTipoArmazenamento),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbMemoriaRam),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbPlacaDeVideo),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbSistemaOperacional),
                ComponentsRequierementsImpl.txfMacAdress.getText(),

                receiverInterface.getFk_equipamentoID()
        );
    }

    @Override
    public void valueForDelete() {
        receiverInterface.comunicationSqlCommandIUD(
                sqlDelete,

                ComponentsRequierementsImpl.txf_campoDeBusca.getText(),
                ComponentsRequierementsImpl.txf_campoDeBusca.getText()
        );
    }

    @Override
    public void valueForUpdate() {
        receiverInterface.comunicationSqlCommandIUD(
                sqlUpdate,

                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbTipoArmazenamento),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbMemoriaRam),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbPlacaDeVideo),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbSistemaOperacional),

                ComponentsRequierementsImpl.txf_campoDeBusca.getText(),
                ComponentsRequierementsImpl.txf_campoDeBusca.getText()
        );
    }

    @Override
    public List valueForRead() {
        return receiverInterface.communicationSqlCommandList(sqlRead);
    }

    @Override
    public List valueForSearch(String... clausule) {
        insertValues(receiverInterface.communicationSqlCommandSearch(sqlSearch, clausule));
        return receiverInterface.communicationSqlCommandSearch(sqlSearch, clausule);
    }

    public void insertValues(List<Maquina> data) {
        Maquina x = data.get(0);

        StaticFieldRequierementsVar.txfPatrimonio.setText(x.getEquipamento().getPatrimonio());
        StaticFieldRequierementsVar.txfServiceTag.setText(x.getEquipamento().getServicetag());
        StaticFieldRequierementsVar.cbAndar.setSelectedItem(x.getEquipamento().getAmbiente().getAndar());
        StaticFieldRequierementsVar.cbDepartamento.setSelectedItem(x.getEquipamento().getAmbiente().getDepartamento());
        StaticFieldRequierementsVar.cbSetor.setSelectedItem(x.getEquipamento().getAmbiente().getSetor());
        StaticFieldRequierementsVar.cbMarca.setSelectedItem(x.getEquipamento().getMarca());
        StaticFieldRequierementsVar.cbModelo.setSelectedItem(x.getEquipamento().getModelo());
        StaticFieldRequierementsVar.cbStatus.setSelectedItem(x.getEquipamento().getStatus());
        StaticFieldRequierementsVar.cbPlacaDeVideo.setSelectedItem(x.getGPU());
        StaticFieldRequierementsVar.cbSistemaOperacional.setSelectedItem(x.getSistemaOperacional());
        StaticFieldRequierementsVar.cbMemoriaRam.setSelectedItem(x.getMemoriaRAM());
        StaticFieldRequierementsVar.cbTipoArmazenamento.setSelectedItem(x.getArmazenamento());
        StaticFieldRequierementsVar.txfMacAdress.setText(x.getMacAddres());
        StaticFieldRequierementsVar.txaObersevacao.setText(x.getEquipamento().getObservacao());
        StaticFieldRequierementsVar.cbDisponibilidadeEmprestimo.setSelectedItem(x.getEquipamento().getDisponivelEmprestimo());

    }

}
