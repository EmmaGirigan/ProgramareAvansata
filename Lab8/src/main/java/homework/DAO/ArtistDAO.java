package homework.DAO;

import compulsory.Database;
import homework.entry.Artist;

import java.sql.*;

public class ArtistDAO implements DAO {
    public void create(Artist artist) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public Artist findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where name='" + name + "'")) {
            rs.next();
            return new Artist(rs.getInt(0), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Object object) {}

    @Override
    public Integer findById(int id){
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where id='" + id + "'")) {
            rs.next();
            return rs.next() ? rs.getInt(1) : null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
