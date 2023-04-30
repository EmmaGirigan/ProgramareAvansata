package compulsory.DAO;

import compulsory.Database;

import java.sql.*;

public class AlbumDAO extends DAO{

    @Override
    public void create(int year, String name, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(String name){}

    @Override
    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer findById(int id){
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where id='" + id + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}


