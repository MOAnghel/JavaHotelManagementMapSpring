package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

/**
 * Super class entity for client and employee
 */

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends BaseEntity{

    @Column
    protected String name;

    @Column
    protected String email;

    @Column
    protected String phoneNumber;

    public Person copy() {
        return new Person(name, email, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
