package compulsory.repositories;

import compulsory.entity.GenresEntity;

public class GenreRepository extends AbstractRepository <GenresEntity, Integer> {
    public GenreRepository(String type) {
        super(type);
    }
}
