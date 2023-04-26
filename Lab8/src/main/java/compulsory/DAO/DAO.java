package compulsory.DAO;

import java.security.PublicKey;
import java.sql.SQLException;

public abstract class DAO {
    public abstract void create(String name) throws SQLException;
    public abstract Integer findByName(String name);

    public abstract Object findById(int id) throws SQLException;

}
