package model.objectModel;

import java.sql.PreparedStatement;
import java.util.List;

public interface ObjectInterface {


    List<Object> listForSQL(PreparedStatement pstm); // Necessario para a criação das tabelas do SQL
}
