package com.example.demo.Repository.InMemory;

import com.example.demo.Models.Room;
import com.example.demo.Proxy.IRoomRepository;

import java.util.*;

public class RoomInMemoryRepository extends InMemoryRepository<Room, UUID> implements IRoomRepository {

    private RoomInMemoryRepository() {
        Room item1 = new Room();
        Room item2 = new Room();
        save(item1);
        save(item2);
    }

    public static RoomInMemoryRepository createInstance() {
        return new RoomInMemoryRepository();
    }

    public List<Room> getAllEquipmentItems() {
        return new ArrayList<>(map.values());
    }

    @Override
    public synchronized  <E extends Room> E save(E entity) {
        if (entity.getId() != null && map.containsKey(entity.getId())) map.put(entity.getId(), entity);
        map.put(entity.getId(), entity);
        return entity;
    }

    public Optional<List<Room>> findByRoomNumber(Integer number) {
        ArrayList<Room> result = new ArrayList<>();
        for (Room item : map.values())
        {
            if (Objects.equals(item.getRoomNumber(), number)) result.add(item);
        }
        return Optional.of(result);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }
}
