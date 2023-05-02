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
                "insert into albums (release_year, name, artist, genre) values (?, ?, ?, ?)")) {
            pstmt.setInt(1, album.getYear());
            pstmt.setString(2, album.getName());
            pstmt.setObject(3, album.getArtist().toString());
            pstmt.setObject(4, album.getGenre().toString());
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
                     "select * from albums where name='" + name + "'")) {
            rs.next();
            return new Album(rs.getInt("id"), rs.getInt("release_year"), name, (Artist) rs.getObject("artist"), (Genre) rs.getObject("genre"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Album findById(int id){
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where id='" + id + "'")) {
            rs.next();
            return new Album(id , rs.getInt(1), rs.getString(2), (Artist) rs.getObject(3), (Genre) rs.getObject(4));
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}


