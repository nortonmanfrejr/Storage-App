package service.dispatcher;

import model.objectModel.Monitor;
import repository.receiver.ReceiverImpl;
import repository.receiver.ReceiverInterface;
import view.requierements.ComponentsRequierementsImpl;

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
            "INNER JOIN tbequipamento AS equipamento ON monitor.fk_equipamentoID = equipamento.equipamentoID " +
            "INNER JOIN tbambiente AS ambiente ON ambiente.ambienteID = equipamento.fk_ambienteID";


    private final String sqlSearch = "SELECT " +
            "monitor.ajustabilidade, " +
            "equipamento.disponibilidadeEmprestimo, equipamento.tipoEquipamento, " +
            "equipamento.patrimonio, equipamento.servicetag, equipamento.marca, equipamento.modelo, " +
            "ambiente.andar, ambiente.departamento, ambiente.setor, " +
            "equipamento.observacao, equipamento.status " +
            "FROM tbmonitor AS monitor " +
            "INNER JOIN tbequipamento AS equipamento ON monitor.fk_equipamentoID = equipamento.equipamentoID " +
            "INNER JOIN tbambiente AS ambiente ON ambiente.ambienteID = equipamento.fk_ambienteID " +
            "WHERE patrimonio = ? OR servicetag = ?";


    private final String sqlDelete = "DELETE monitor " +
            "FROM tbmonitor AS monitor " +
            "JOIN tbequipamento AS equipamento " +
            "ON monitor.fk_equipamentoID = equipamento.equipamentoID " +
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
        return receiverInterface.communicationSqlCommandSearch(sqlSearch, clausule);
    }


}
