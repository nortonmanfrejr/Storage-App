package connector;

import javax.swing.*;
import java.sql.*;

public class Connector implements ConnectorInterface{

    // TURN THIS CLASS IN A REAL INTERFACE
    public String CLASSPATH = "com.mysql.cj.jdbc.Driver";

//    public final String URL = "jdbc:mysql://172.16.3.180:3306/dbdaddyinventory";
//    public final String USER = "app_inventory";
//    public final String PASSWORD = "daddy@66";
//
    public String URL = "jdbc:mysql://localhost:3306/dbdaddy";
    public String USER = "root";
    public String PASSWORD = "";
    public Connection conn;

    @Override
    public Connection getConnection() {
        try {
            Class.forName(CLASSPATH);

            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }


    @Override
    public void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
