package compulsory.DAO;

import compulsory.Database;

import java.sql.*;

public class ArtistDAO extends DAO{
    @Override
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    @Override
    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Integer findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where id='" + id + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }

    }

}
