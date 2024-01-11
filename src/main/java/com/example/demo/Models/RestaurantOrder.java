package com.example.demo.Models;

import com.example.demo.Models.Enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entity class for storing restaurant orders made by clients of a hotel
 */

@Entity
@Table(name = "restaurantOrder")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantOrder extends BaseEntity{
    //@Column
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID", referencedColumnName = "id")
    private Client client;

    //@Column
    @JsonIgnore
    @OneToMany(mappedBy = "restaurantOrder")
    private Set<Item> items = new HashSet<>();

    @Column
    @Enumerated
    private PaymentMethod paymentMethod;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantOrder that = (RestaurantOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "RestaurantOrder{" +
                "client=" + client +
                ", items=" + items +
                ", paymentMethod=" + paymentMethod +
                ", id=" + id +
                '}';
    }
}
