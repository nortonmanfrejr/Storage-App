package model.jComboBoxModel;

import connector.Connector;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CBoxModel implements ComboBoxModelInterface {


    Connector c = new Connector();
    PreparedStatement pstm;
    ResultSet rs;

    private String data;
    private List<String> dataList;

    @Override
    public List<String> dataListForJCBModel(String sql, String col,String... whereClausule){
        try {
            dataList = new ArrayList<>();

            pstm = c.getConnection().prepareStatement(sql);

            for (int i = 0; i < whereClausule.length; i++)
                pstm.setString((i + 1), whereClausule[i]);

            rs = pstm.executeQuery();

            while (rs.next()){
                data = rs.getString(col);

                if (!dataList.contains(data)) dataList.add(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        } finally {
            c.closeConnection();
        }
        return dataList;
    }

}
