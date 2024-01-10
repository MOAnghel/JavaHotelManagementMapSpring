package com.example.demo.Service;

import com.example.demo.Models.Client;
import com.example.demo.Models.Person;
import com.example.demo.Repository.InMemory.IRepository;
import com.example.demo.Repository.JPA.PersonRepository;
import com.example.demo.Service.Observer.IObserverDeletedClient;
import com.example.demo.Service.Subject.ISubjectDeletedClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service class for implementing Observer Design Pattern for Client entities
 */

@Service
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ClientService extends PersonService<Person> implements IObserverDeletedClient, ISubjectDeletedClient {

    @Autowired
    PersonRepository personRepository;

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
