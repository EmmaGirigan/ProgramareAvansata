package compulsory;

import com.github.javafaker.Faker;
import compulsory.entity.AlbumsEntity;
import compulsory.entity.ArtistsEntity;
import compulsory.repositories.AlbumRepository;
import compulsory.repositories.ArtistRepository;
import jakarta.persistence.EntityManager;

public class FakeData {
    public FakeData(EntityManager em) {
        for(int i=0;i<100;i++){
            fakeArtist(em);
            fakeAlbum(em);
        }
    }
    public void fakeArtist(EntityManager em){
        new ArtistRepository("Artist").create(new ArtistsEntity(new Faker().artist().name()));
    }

    public void fakeAlbum(EntityManager em) {
        new AlbumRepository("Album").create(new AlbumsEntity(new Faker().number().numberBetween(1900, 2023), new Faker().funnyName().name(), new Faker().artist().name(), new Faker().music().genre()));
    }
}
