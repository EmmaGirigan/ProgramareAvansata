package compulsory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Management {
private static EntityManagerFactory emf;
public static Management singleInstance = null;
public Management() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
    if(singleInstance == null)
        singleInstance = new Management();
        return emf;
    }
}

