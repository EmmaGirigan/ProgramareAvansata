package compulsory;

import compulsory.entity.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Management.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Artist artist = new Artist("Beatles");

        em.persist(artist);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}