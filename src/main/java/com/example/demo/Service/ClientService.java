package com.example.demo.Service;

import com.example.demo.Models.Client;
import com.example.demo.Models.Person;
import com.example.demo.Repository.JPA.ClientRepository;
import com.example.demo.Service.Observer.IObserverDeletedClient;
import com.example.demo.Service.Subject.ISubjectDeletedClient;
import org.springframework.stereotype.Service;

/**
 * Service class for implementing Observer Design Pattern for Client entities
 */

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ClientService implements IObserverDeletedClient, ISubjectDeletedClient {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addObserver(IObserverDeletedClient observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedClient observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyDeletedClient(Client client) {
        for(IObserverDeletedClient observer : observerList) {
            observer.deletedClient(client);
        }
    }

    @Override
    public void deletedClient(Client client) {}
}
