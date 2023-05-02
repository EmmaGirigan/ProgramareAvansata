package homework;

import homework.DAO.AlbumDAO;
import homework.DAO.ArtistDAO;
import homework.DAO.GenreDAO;
import homework.entry.Album;
import homework.entry.Artist;
import homework.entry.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            var artists = new ArtistDAO();
            Artist pinkFloyd = new Artist("Pink Floyd");
            artists.create(pinkFloyd);
            Artist michaelJackson = new Artist("Michael Jackson");
            artists.create(michaelJackson);
            var genres = new GenreDAO();
            Genre rock = new Genre("Rock");
            genres.create(rock);
            Genre funk = new Genre("Funk");
            genres.create(funk);
            Genre soul = new Genre("Soul");
            genres.create(soul);
            Genre pop = new Genre("Pop");
            genres.create(pop);
            Database.createConnection();
            Database.getConnection().commit();
            var albums = new AlbumDAO();
            Album theWall = new Album(1979, "The Wall", pinkFloyd, rock);
            albums.create(theWall);
            albums.findByName("The Wall");
            Album thriller = new Album(1982, "Thriller", michaelJackson, pop);
            albums.create(thriller);
            Database.getConnection().commit();
            con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select * from albums")) {
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