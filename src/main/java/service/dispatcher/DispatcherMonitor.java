package service.dispatcher;

import model.objectModel.Maquina;
import model.objectModel.Monitor;
import repository.receiver.ReceiverImpl;
import repository.receiver.ReceiverInterface;
import view.requierements.ComponentsRequierementsImpl;
import view.requierements.StaticFieldRequierementsVar;

import java.util.List;

public class DispatcherMonitor implements DispatcherInterface {

    private final String sqlInsert = "INSERT INTO tbmonitor (" +
            "ajustabilidade, fk_equipamentoID) VALUES (?,?)";


    private final String sqlRead = "SELECT " +
            "monitor.ajustabilidade, " +
            "equipamento.disponibilidadeEmprestimo, equipamento.tipoEquipamento, " +
            "equipamento.patrimonio, equipamento.servicetag, equipamento.marca, equipamento.modelo, " +
            "ambiente.andar, ambiente.departamento, ambiente.setor, " +
            "equipamento.observacao, equipamento.status " +
            "FROM tbmonitor AS monitor " +
            "INNER JOIN tbequipamento AS equipamento ON monitor.fk_equipamentoID = equipamento.equipamentoID AND equipamento.tipoEquipamento = 'Monitor' " +
            "INNER JOIN tbambiente AS ambiente ON ambiente.ambienteID = equipamento.fk_ambienteID";


    private final String sqlSearch = "SELECT " +
            "monitor.ajustabilidade, " +
            "equipamento.disponibilidadeEmprestimo, equipamento.tipoEquipamento, " +
            "equipamento.patrimonio, equipamento.servicetag, equipamento.marca, equipamento.modelo, " +
            "ambiente.andar, ambiente.departamento, ambiente.setor, " +
            "equipamento.observacao, equipamento.status " +
            "FROM tbmonitor AS monitor " +
            "INNER JOIN tbequipamento AS equipamento ON monitor.fk_equipamentoID = equipamento.equipamentoID AND equipamento.tipoEquipamento = 'Monitor' " +
            "INNER JOIN tbambiente AS ambiente ON ambiente.ambienteID = equipamento.fk_ambienteID " +
            "WHERE patrimonio = ? OR servicetag = ?";


    private final String sqlDelete = "DELETE monitor " +
            "FROM tbmonitor AS monitor " +
            "INNER JOIN tbequipamento AS equipamento " +
            "ON monitor.fk_equipamentoID = equipamento.equipamentoID AND equipamento.tipoEquipamento = 'Monitor' " +
            "WHERE equipamento.patrimonio = ? " +
            "OR equipamento.servicetag = ?";

    private final ReceiverInterface receiverInterface = new ReceiverImpl(new Monitor());

    @Override
    public void valueForInsert() {
        receiverInterface.comunicationSqlCommandIUD(
                sqlInsert,

                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbAjustabilidadeMonitor),
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
        // this update function is not necessary to monitor
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

    public void insertValues(List<Monitor> data) {
        Monitor x = data.get(0);

        StaticFieldRequierementsVar.txfPatrimonio.setText(x.getEquipamento().getPatrimonio());
        StaticFieldRequierementsVar.txfServiceTag.setText(x.getEquipamento().getServicetag());
        StaticFieldRequierementsVar.cbAndar.setSelectedItem(x.getEquipamento().getAmbiente().getAndar());
        StaticFieldRequierementsVar.cbDepartamento.setSelectedItem(x.getEquipamento().getAmbiente().getDepartamento());
        StaticFieldRequierementsVar.cbSetor.setSelectedItem(x.getEquipamento().getAmbiente().getSetor());
        StaticFieldRequierementsVar.cbMarca.setSelectedItem(x.getEquipamento().getMarca());
        StaticFieldRequierementsVar.cbModelo.setSelectedItem(x.getEquipamento().getModelo());
        StaticFieldRequierementsVar.cbStatus.setSelectedItem(x.getEquipamento().getStatus());
        StaticFieldRequierementsVar.cbAjustabilidadeMonitor.setSelectedItem(x.getAjustabilidade());
        StaticFieldRequierementsVar.txaObersevacao.setText(x.getEquipamento().getObservacao());
        StaticFieldRequierementsVar.cbDisponibilidadeEmprestimo.setSelectedItem(x.getEquipamento().getDisponivelEmprestimo());

    }

}
