package compulsory.repositories;

import compulsory.Management;
import compulsory.entity.AlbumsEntity;
import compulsory.entity.ArtistsEntity;
import jakarta.persistence.EntityManager;

public class AlbumRepository extends AbstractRepository <AlbumsEntity, Integer> {
    public AlbumRepository(String type) {
        super(type);
    }
}
