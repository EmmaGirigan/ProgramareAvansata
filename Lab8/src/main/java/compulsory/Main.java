package compulsory;

import compulsory.DAO.AlbumDAO;
import compulsory.DAO.ArtistDAO;
import compulsory.DAO.GenreDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.createConnection();
            Database.getConnection().commit();
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.findByName("The Wall");
            albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            Database.getConnection().commit();
            con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select * from music")) {
                System.out.println(rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            try {
                assert con != null;
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}