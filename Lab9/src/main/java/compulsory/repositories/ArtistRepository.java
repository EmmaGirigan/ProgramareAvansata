package compulsory.repositories;

import compulsory.Management;
import compulsory.entity.ArtistsEntity;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ArtistRepository extends AbstractRepository{
    private EntityManager em;

    public ArtistRepository() {
        this.em = (EntityManager) Management.getEntityManagerFactory();
    }
    public ArtistsEntity findById(int id) {
        return (ArtistsEntity) em.createNamedQuery("Artist.findById")
                .setParameter("id", id)
                .getResultList();

    }

    public ArtistsEntity findByName(String name){
        return (ArtistsEntity) em.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public void create(ArtistsEntity artist){

    }
}
