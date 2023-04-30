package compulsory.DAO;

import compulsory.Database;

import java.sql.*;

public class GenreDAO extends DAO{
    @Override
    public void create(String name)  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer findById(int id) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where id='" + id + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
