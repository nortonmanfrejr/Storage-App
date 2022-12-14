package repository.receiver;

import connector.Connector;
import connector.ConnectorInterface;
import lombok.NoArgsConstructor;
import model.objectModel.ObjectInterface;
import view.requierements.ComponentsRequierementsImpl;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@NoArgsConstructor
public class ReceiverImpl implements ReceiverInterface {

    private ConnectorInterface connectorInterface = new Connector();
    private ObjectInterface objectInterface;

    private PreparedStatement pstm;
    private ResultSet rs;

    public ReceiverImpl(ObjectInterface objectInterface) {
        this.objectInterface = objectInterface;
    }

    private final String getEquipamentoFk = "SELECT equipamentoID " +
            "FROM tbequipamento " +
            "WHERE patrimonio = ? AND servicetag = ?";

    private final String getAmbienteFK  = "SELECT ambienteID " +
            "FROM tbambiente " +
            "WHERE andar = ? AND departamento = ? AND setor = ?";

    private int foreignKey;

    /**
     * A logica IUD funciona para comandos que alterar a base de dados, recebendo o comando através de um parametro
     * inserido pela classe de serviço.
     * @param sqlCommand  a ser inserido na classe de serviço.
     * SQL Commands ex: <br>
     * INSERT INTO tb_name (idName,name) VALUES (?,?); <br>
     * UPDATE tb_name SET name = ? WHERE idName = ?; <br>
     * DELETE * FROM tb_name WHERE idName = ?; <br>
     * @param args que ira ocupar o lugar dos ? <br>
     * Os args seguem a mesma ordem dos ?, ex: SET name = ? passe um txfName.getText(), pois então ao utilizar esta função fique atento aos argumentos
     * passados no sqlCommand e aos argumentos, pois tem de seguir a mesma ordem.
     * */
    @Override
    public void comunicationSqlCommandIUD(String sqlCommand, String... args) {
        try {
            pstm = connectorInterface.getConnection().prepareStatement(sqlCommand);

            for (int i = 0; i < args.length; i++)
                pstm.setString((i + 1),args[i]);

            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectorInterface.closeConnection();
        }
    }
    @Override
    public List communicationSqlCommandSearch(String searchSQL, String... whereClausule) {
        try {
            pstm = connectorInterface.getConnection().prepareStatement(searchSQL);

            for (int i = 0; i < whereClausule.length; i++)
                pstm.setString((i + 1), whereClausule[i]);

            return objectInterface.listForSQL(pstm);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        } finally {
            connectorInterface.closeConnection();
        }
        return objectInterface.listForSQL(pstm);
    }

    @Override
    public List communicationSqlCommandList(String readSQL) {
        try {
            pstm = connectorInterface.getConnection().prepareStatement(readSQL);
            return objectInterface.listForSQL(pstm);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        } finally {
            connectorInterface.closeConnection();
        }
        return objectInterface.listForSQL(pstm);
    }

    @Override
    public int selectFKForSQLCommand(String sql, String col, String... whereClausule) {
        try {
            pstm = connectorInterface.getConnection().prepareStatement(sql);

            for (int i = 0; i < whereClausule.length; i++)
                pstm.setString((i + 1), whereClausule[i]);

            rs = pstm.executeQuery();

            while (rs.next()) foreignKey = rs.getInt(col);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        } finally {
            connectorInterface.closeConnection();
        }
        return foreignKey;
    }
    @Override
    public String getFk_ambienteID() {
        return String.valueOf(
                selectFKForSQLCommand(
                        getAmbienteFK,
                        "ambienteID",

                        valueOfComboBoxDTO(ComponentsRequierementsImpl.cbAndar),
                        valueOfComboBoxDTO(ComponentsRequierementsImpl.cbDepartamento),
                        valueOfComboBoxDTO(ComponentsRequierementsImpl.cbSetor)
                ));
    }

    @Override
    public String getFk_equipamentoID() {
        return String.valueOf(
                selectFKForSQLCommand(
                        getEquipamentoFk,
                        "equipamentoID",

                        ComponentsRequierementsImpl.txfPatrimonio.getText(),
                        ComponentsRequierementsImpl.txfServiceTag.getText()
                ));
    }

    // verificar depois, problema na captura de texto das combobox de maquinas
    // Monitor operando normalmente e equipamento tambem
    @Override
    public String valueOfComboBoxDTO(JComboBox<String> jComboBox) {
        return String.valueOf(
                jComboBox.
                        getSelectedItem());
    }
}
