package com.example.demo.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

/**
 * BaseEntity class to inherit ID
 */

@MappedSuperclass
public class BaseEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    protected UUID id;

    public UUID getId() {
        return id;
    }
}
