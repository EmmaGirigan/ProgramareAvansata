package compulsory;

import com.github.javafaker.Faker;
import compulsory.entity.AlbumsEntity;
import compulsory.entity.ArtistsEntity;
import compulsory.repositories.AlbumRepository;
import compulsory.repositories.ArtistRepository;
import compulsory.repositories.GenreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

import compulsory.FakeData;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Management.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        FakeData fakeData = new FakeData(em);
        em.close();
        emf.close();
    }
}