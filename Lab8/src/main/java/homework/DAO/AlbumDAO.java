package homework.DAO;

import homework.Database;
import homework.entry.Album;
import homework.entry.Artist;
import homework.entry.Genre;

import java.sql.*;

public class AlbumDAO implements DAO {
    public void create(Album album) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (year, name, artist, genre) values (?, ?, ?)")) {
            pstmt.setInt(1, album.getYear());
            pstmt.setString(2, album.getName());
            pstmt.setObject(3, album.getArtist());
            pstmt.setObject(4, album.getGenre());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Object object) {}

    @Override
    public Album findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + name + "'")) {
            return new Album(rs.getInt(0), rs.getInt(1), name, (Artist) rs.getObject(3), (Genre) rs.getObject(4));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Album findById(int id){
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where id='" + id + "'")) {
            return new Album(id , rs.getInt(1), rs.getString(2), (Artist) rs.getObject(3), (Genre) rs.getObject(4));
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}


