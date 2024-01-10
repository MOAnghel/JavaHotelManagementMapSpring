package com.example.demo.Repository.InMemory;

import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryRepository<Entity, ID> implements IRepository<Entity, ID> {
    protected final HashMap<ID, Entity> map = new HashMap<>();

    @Override
    public <E extends Entity> boolean exists(Example<E> entity) {
        return map.containsValue(entity.getProbe());
    }

    @Override
    public List<Entity> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public boolean existsById(ID id) {
        return map.containsKey(id);
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public Optional<Entity> findById(ID id) {
        Entity entity = map.get(id);
        if(entity == null) {
            return Optional.empty();
        }
        return Optional.of(entity);
    }
}
