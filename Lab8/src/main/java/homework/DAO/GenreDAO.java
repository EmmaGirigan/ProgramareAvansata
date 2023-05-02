package homework.DAO;

import compulsory.Database;
import homework.entry.Genre;

import java.sql.*;

public class GenreDAO implements DAO {
    public void create(Genre genre) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Object object) {}

    @Override
    public Genre findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where name='" + name + "'")) {
            rs.next();
            return new Genre(rs.getInt(0), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Genre findById(int id) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where id='" + id + "'")) {
            rs.next();
            return new Genre(id, rs.getString(1));
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
