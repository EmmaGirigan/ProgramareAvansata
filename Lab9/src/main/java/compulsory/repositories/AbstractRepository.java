package compulsory.repositories;

import java.util.Optional;

public abstract class AbstractRepository{
    abstract Optional <T> findById(int id);
}
