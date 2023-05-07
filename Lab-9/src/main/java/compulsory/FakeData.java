package compulsory;

import com.github.javafaker.Faker;
import compulsory.entity.AlbumsEntity;
import compulsory.entity.ArtistsEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class FakeData {

    List<ArtistsEntity> fakeArtists = new ArrayList<>();
    List<AlbumsEntity> fakeAlbums = new ArrayList<>();
    private List<ArtistsEntity> fakeArtists(){
        var artistArray = IntStream.rangeClosed(0, 300)
                .mapToObj(i -> new ArtistsEntity(new Faker().artist().name()))
                .toArray(ArtistsEntity[]::new);
        Collections.addAll(fakeArtists, artistArray);
        return fakeArtists;
    }
    private List<AlbumsEntity> fakeAlbums(){
        var albumArray = IntStream.rangeClosed(0, 300)
                .mapToObj(i -> new AlbumsEntity(new Faker().funnyName().name()))
                .toArray(AlbumsEntity[]::new);
        Collections.addAll(fakeAlbums, albumArray);
        return fakeAlbums;
    }
}
