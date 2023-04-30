package compulsory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MusicTest {
    private Connection con;

    @Before
    public void setUp() throws Exception {
        // Connect to the database
        String url = "jdbc:mysql://localhost/testdb";
        String user = "username";
        String password = "password";
        con = DriverManager.getConnection(url, user, password);
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(con);
    }

    @Test
    public void testCreate() {

    }
    @Test
    public void testFindById(){

    }
    @Test
    public void testFindByName(){

    }

    @After
    public void close() throws Exception {
        // Close the database connection
        if (con != null) {
            con.close();
        }


    }
}