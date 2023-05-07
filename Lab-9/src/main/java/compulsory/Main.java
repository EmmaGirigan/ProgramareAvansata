package compulsory;

import compulsory.entity.ArtistsEntity;
import compulsory.repositories.AlbumRepository;
import compulsory.repositories.ArtistRepository;
import compulsory.repositories.GenreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Management.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        ArtistRepository artistRepository = new ArtistRepository("Artist");
        AlbumRepository albumRepository = new AlbumRepository("Album");
        GenreRepository genreRepository = new GenreRepository("Genre");
        ArtistsEntity artist = new ArtistsEntity("Beatles");
        artistRepository.create(artist);
        em.close();
        emf.close();
    }
}