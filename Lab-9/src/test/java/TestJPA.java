import compulsory.entity.AlbumsEntity;
import compulsory.entity.GenresEntity;
import compulsory.repositories.ArtistRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import compulsory.entity.ArtistsEntity;
import org.postgresql.copy.PGCopyInputStream;

public class TestJPA {
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    @Before
    public void setUp(){
        em.getTransaction().begin();
    }
    @Test
    public void testArtist(){
        ArtistsEntity artist = new ArtistsEntity("BritneySpears");
        em.persist(artist);
        em.getTransaction().commit();
    }
    @Test
    public void testAlbum(){
        AlbumsEntity album = new AlbumsEntity("Circus");
        em.persist(album);
        em.getTransaction().commit();
    }
    @Test
    public void testGenre(){
        GenresEntity genre = new GenresEntity("Pop");
        em.persist(genre);
        em.getTransaction().commit();
    }
    @After
    public void close(){
        em.close();
        emf.close();
    }

}
