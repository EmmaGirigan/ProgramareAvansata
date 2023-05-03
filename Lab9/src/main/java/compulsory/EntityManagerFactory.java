package compulsory;

import compulsory.entity.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerFactory {
    Persistence.createEntityManagerFactory("ExamplePU");
    EntityManager em = emf.createEntityManager();

 em.getTransaction().begin();
    Artist artist = new Artist("Beatles");
 em.persist(artist);

    Artist a = (Artist)em.createQuery(
                    "select e from Artist e where e.name='Beatles'")
            .getSingleResult();
 a.setName("The Beatles");
 em.getTransaction().commit();
 em.close();
 emf.close();

}
