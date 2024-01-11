package com.example.demo.Repository.JPA;

import com.example.demo.Models.Room;
import com.example.demo.Proxy.IRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>, IRoomRepository {

}
