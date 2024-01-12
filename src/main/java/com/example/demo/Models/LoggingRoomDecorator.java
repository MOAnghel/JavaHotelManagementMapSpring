package com.example.demo.Models;

public class LoggingRoomDecorator implements IRoom{
    private Room decoratedRoom = null;

    public LoggingRoomDecorator(Room room) {
        this.decoratedRoom = room;
    }

    @Override
    public Integer getRoomNumber() {
        System.out.println("Logging: Room number retrieval...");
        Integer number = decoratedRoom.getRoomNumber();
        System.out.println("Logging: Room number retrieved: " + number);
        return number;
    }
}
