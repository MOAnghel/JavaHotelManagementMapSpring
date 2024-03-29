package com.example.demo.Service.Subject;

import com.example.demo.Models.Client;
import com.example.demo.Service.Observer.IObserverDeletedClient;

import java.util.ArrayList;
/**
 * Interface for implementing Observer Pattern for Client Service
 */


public interface ISubjectDeletedClient {
    ArrayList<IObserverDeletedClient> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedClient observer);
    void removeObserver(IObserverDeletedClient observer);
    void notifyDeletedClient(Client client);
}
