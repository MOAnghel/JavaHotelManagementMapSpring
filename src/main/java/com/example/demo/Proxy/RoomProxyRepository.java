package com.example.demo.Proxy;

import com.example.demo.Factory.RepoTypes;
import com.example.demo.Factory.RoomRepoFactory;
import com.example.demo.Models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Proxy class for the RoomRepository repository
 * ImplementsIRoomRepository interface and ProxyRepository abstract class
 */

@Component
public class RoomProxyRepository extends ProxyRepository<Room, Long> implements IRoomRepository {
    private ICustomRoomRepository customRepo;
    private final RoomRepoFactory factory;

    @Autowired
    public RoomProxyRepository(ApplicationContext applicationContext) {
        factory = applicationContext.getBean(RoomRepoFactory.class);
        selectJpa();
    }
    @Override
    public void selectJpa() {
        currentRepo = factory.buildIRepository(RepoTypes.JPA);
        customRepo = factory.buildCustom(RepoTypes.JPA);
    }

    @Override
    public void selectInMemory()
    {
        currentRepo = factory.buildIRepository(RepoTypes.InMemory);
        customRepo = factory.buildCustom(RepoTypes.InMemory);
    }

    @Override
    public Optional<List<Room>> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Room>> findByRoomNumber(Integer number) {
        return customRepo.findByRoomNumber(number);
    }

    @Override
    public boolean existsById(Long uuid) {
        return false;
    }
}
