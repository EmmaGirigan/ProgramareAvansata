package compulsory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Management {
private static EntityManagerFactory emf;
public static Management singleInstance = null;
public Management() {
        emf = Persistence.createEntityManagerFactory("hibernate-core");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
    if(singleInstance == null)
        singleInstance = new Management();
        return emf;
    }
}

