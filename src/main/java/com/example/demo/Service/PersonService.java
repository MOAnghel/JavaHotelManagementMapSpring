package com.example.demo.Service;

import com.example.demo.Models.Person;
import com.example.demo.Repository.InMemory.IRepository;
import com.example.demo.Repository.JPA.PersonRepository;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Service for extracting Person repository info
 */

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@NoArgsConstructor
public abstract class PersonService<PersonType extends Person> extends BaseService<PersonType, UUID> {

}
