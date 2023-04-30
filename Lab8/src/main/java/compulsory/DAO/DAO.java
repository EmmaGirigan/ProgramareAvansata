package compulsory.DAO;

import java.sql.SQLException;

public abstract class DAO {
    public abstract void create(String name) throws SQLException;
//    @Override
    public abstract Integer findByName(String name);
    public void create(int year, String name, String artist, String genre) throws SQLException {}

    public abstract Integer findById(int id) throws SQLException;
}
