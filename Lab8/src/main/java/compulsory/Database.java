package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return conn;
    }
    private static void createConnection() {
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // handle the exception
            }
        }
    }

    public static void rollback() {
    }
}
