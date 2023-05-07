package compulsory.repositories;

import compulsory.Management;
import compulsory.entity.AbstractEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.io.Serializable;

public abstract class AbstractRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private final EntityManagerFactory emf = Management.getEntityManagerFactory();
    private final EntityManager em = emf.createEntityManager();
    private String type;

    public AbstractRepository(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T findById(ID id) {
        return (T) em.createNamedQuery(this.getType() + "findById")
                .setParameter("id", id)
                .getResultList();
    }

    public T findByName(String name) {
        String typ = this.getType() +
                "findByName";
        return (T) em.createNamedQuery(typ)
                .setParameter("name", name)
                .getResultList();
    }

    public void create(T entity){
        em.persist(entity);
    }
    public boolean persist(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            handleException(e);
            em.getTransaction().rollback();
        }
        return false;
    }
    private void handleException(Exception e) {
        throw new PersistenceException(e);
    }
}