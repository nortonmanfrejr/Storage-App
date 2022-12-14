package connector;

import java.sql.Connection;

public interface ConnectorInterface {

    Connection getConnection();
    void closeConnection();
}
