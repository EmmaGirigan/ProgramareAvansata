package compulsory.repositories;

import compulsory.entity.ArtistsEntity;
import compulsory.Management;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;

public class ArtistRepository extends AbstractRepository <ArtistsEntity, Integer>{

    public ArtistRepository(String type) {
        super(type);
    }
}
