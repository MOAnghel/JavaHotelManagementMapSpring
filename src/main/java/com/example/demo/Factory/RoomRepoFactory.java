package com.example.demo.Factory;

import com.example.demo.Models.Room;
import com.example.demo.Proxy.ICustomRoomRepository;
import com.example.demo.Repository.InMemory.IRepository;
import com.example.demo.Repository.InMemory.RoomInMemoryRepository;
import com.example.demo.Repository.JPA.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomRepoFactory implements IRepoFactory<Room, Long> {
    private final ApplicationContext applicationContext;

    @Autowired
    public RoomRepoFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Override
    public IRepository<Room, Long> buildIRepository(RepoTypes type) {
        return switch (type) {
            case JPA -> getJpa();
            case InMemory -> getInMemory();
        };
    }

    public ICustomRoomRepository buildCustom(RepoTypes type) {
        return switch (type) {
            case JPA -> getJpa();
            case InMemory -> getInMemory();
        };
    }

    private RoomRepository getJpa() {
        return applicationContext.getBean(RoomRepository.class);
    }

    private RoomInMemoryRepository getInMemory() {
        return applicationContext.getBean(RoomInMemoryRepository.class);
    }
}
