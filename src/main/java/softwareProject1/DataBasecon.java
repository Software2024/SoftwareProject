package softwareProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBasecon {

    private static final String URL = "jdbc:postgresql://localhost:5432/dream";
    private static final String USER = "postgres";
    private static final String PASSWORD = "shahd";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}