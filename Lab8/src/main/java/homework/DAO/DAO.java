package homework.DAO;

import homework.entry.Album;
import homework.entry.Artist;
import homework.entry.Entry;
import homework.entry.Genre;

import java.sql.SQLException;

public interface DAO {
    public void create(Object object) ;

    public Object findByName(String name);

    public Object findById(int id);
}
