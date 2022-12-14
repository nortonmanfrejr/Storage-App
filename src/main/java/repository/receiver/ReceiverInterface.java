package repository.receiver;

import javax.swing.*;
import java.util.List;

public interface ReceiverInterface {

    void comunicationSqlCommandIUD(String sqlCommand, String... args);
    List communicationSqlCommandSearch(String searchSQL, String... whereClausule);
    List communicationSqlCommandList(String readSQL);

    int selectFKForSQLCommand(String sql, String col, String... whereClausule);
    String getFk_ambienteID();
    String getFk_equipamentoID();
    String valueOfComboBoxDTO(JComboBox<String> jComboBox);

}
