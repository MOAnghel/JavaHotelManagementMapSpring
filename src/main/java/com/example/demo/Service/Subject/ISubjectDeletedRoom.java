package com.example.demo.Service.Subject;

import com.example.demo.Models.Room;
import com.example.demo.Service.Observer.IObserverDeletedRoom;

import java.util.ArrayList;
/**
 * Interface for implementing Obsrver Pattern for Room Service
 */

public interface ISubjectDeletedRoom {
    ArrayList<IObserverDeletedRoom> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedRoom observer);
    void removeObserver(IObserverDeletedRoom observer);
    void notifyDeletedRoom(Room room);
}
