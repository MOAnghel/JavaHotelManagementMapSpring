package com.example.demo.Proxy;

import com.example.demo.Models.Room;
import com.example.demo.Repository.InMemory.IRepository;

import java.util.UUID;

/**
 * Interface for implementing room repository
 */

public interface IRoomRepository extends IRepository<Room, Long>, ICustomRoomRepository {
}
