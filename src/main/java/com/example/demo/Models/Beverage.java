package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class for representing beverages to be stored in a restaurants menu
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "beverage")
public class Beverage extends Item{

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String description;

    @Column
    private Integer volume;

    @Column
    private Integer alcoholPercentage;

    @Override
    public String toString() {
        return "Beverage{" +
                "volume=" + volume +
                ", alcoholPercentage=" + alcoholPercentage +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
