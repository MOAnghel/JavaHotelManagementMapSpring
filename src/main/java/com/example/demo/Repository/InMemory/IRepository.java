package com.example.demo.Repository.InMemory;

import org.springframework.data.domain.Example;
import java.util.List;
import java.util.Optional;

public interface IRepository<Entity, ID> {
    <E extends Entity> E save(E entity);

    <E extends Entity> boolean exists(Example<E> entity);

    List<Entity> findAll();

    void deleteById(ID id);

    Optional<Entity> findById(ID id);

    boolean existsById(ID id);
}
