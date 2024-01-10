package com.example.demo.Service;

import com.example.demo.Repository.InMemory.IRepository;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <Entity> the entity type
 * @param <IdType> the entity type identifier
 */

@Service
@NoArgsConstructor
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class BaseService<Entity, IdType> implements IService<Entity, IdType>
{
    protected IRepository<Entity, IdType> repository;
    public BaseService(IRepository<Entity, IdType> repository)
    {
        this.repository = repository;
    }

    @Override
    public Optional<Entity> add(Entity object) throws Exception {
        if (repository.exists(Example.of(object))) throw new Exception();
        return Optional.of(repository.save(object));
    }

    @Override
    public Optional<List<Entity>> getAll() {
        List<Entity> list = repository.findAll();
        if (list.isEmpty()) return Optional.empty();
        Optional<List<Entity>> returnStatment = Optional.of(list);
        return returnStatment;
    }

    @Override
    public Optional<Entity> update(IdType id, Entity object) {

        if (!repository.existsById(id)){
            return Optional.empty();
        }
        repository.deleteById(id);
        return Optional.of(repository.save(object));

    }

    @Override
    public Optional<Entity> delete(IdType id) {
        if (!repository.existsById(id)){
            return Optional.empty();
        }
        Optional<Entity> object_to_remove = repository.findById(id);
        repository.deleteById(id);
        return object_to_remove;
    }

    @Override
    public Optional<Entity> getEntityByKey(IdType id) {
        return repository.findById(id);
    }
}