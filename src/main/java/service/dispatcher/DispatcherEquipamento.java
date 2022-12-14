package service.dispatcher;

import model.objectModel.EquipamentoFromAnotherObjects;
import repository.receiver.ReceiverImpl;
import repository.receiver.ReceiverInterface;
import view.requierements.ComponentsRequierementsImpl;

import java.util.List;

public class DispatcherEquipamento implements DispatcherInterface {

    private final String sqlInsert = "INSERT INTO tbequipamento (" +
            "tipoEquipamento," +
            "patrimonio, " +
            "servicetag," +
            "modelo," +
            "marca," +
            "observacao," +
            "status," +
            "disponibilidadeEmprestimo," +
            "fk_ambienteID) " +
            "VALUES (?,?,?,?,?,?,?,?,?);";

    private final String sqlUpdate = "UPDATE tbequipamento " +
            "SET fk_ambienteID = ?, observacao = ?, status = ?, disponibilidadeEmprestimo = ?" +
            "WHERE patrimonio = ? OR servicetag = ?";

    private final String sqlDelete = "DELETE " +
            "FROM tbequipamento " +
            "WHERE patrimonio = ? OR servicetag = ? ";

    private final String sqlRead = "select " +
            "e.disponibilidadeEmprestimo, e.tipoEquipamento,e.patrimonio, e.servicetag, e.marca, e.modelo, a.andar,a.departamento,a.setor,e.observacao,e.status " +
            "from tbequipamento as e " +
            "inner join tbambiente as a on e.fk_ambienteID = a.ambienteID;";
    private final String sqlSearch = String.format("%s WHERE patrimonio = ? OR servicetag = ?",sqlRead);

    ReceiverInterface receiverInterface = new ReceiverImpl(new EquipamentoFromAnotherObjects());
    @Override
    public void valueForInsert() {
        receiverInterface.comunicationSqlCommandIUD(
                sqlInsert,

                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbTipoEquipamento),
                ComponentsRequierementsImpl.txfPatrimonio.getText(),
                ComponentsRequierementsImpl.txfServiceTag.getText(),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbModelo),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbMarca),
                ComponentsRequierementsImpl.txaObersevacao.getText(),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbStatus),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbDisponibilidadeEmprestimo),

                receiverInterface.getFk_ambienteID()
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

                receiverInterface.getFk_ambienteID(),
                ComponentsRequierementsImpl.txaObersevacao.getText(),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbStatus),
                receiverInterface.valueOfComboBoxDTO(ComponentsRequierementsImpl.cbDisponibilidadeEmprestimo),

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
        return receiverInterface.communicationSqlCommandSearch(sqlSearch, clausule);
    }


}
