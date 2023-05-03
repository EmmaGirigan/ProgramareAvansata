package compulsory.repositories;

import compulsory.entity.Entity;
import jakarta.persistence.EntityManager;

import java.io.Serializable;

import static java.security.Policy.handleException;

public abstract class DataRepository
        <T extends Entity, ID extends Serializable> {
    private EntityManager em; //create it somehow
    public T findById(ID id) {
    }
    public void persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            commit();
            return true;
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
    }
}
