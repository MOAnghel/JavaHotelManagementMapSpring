package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

/**
 * Entity class representing restaurant items as a base class for food or beverages
 */

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends BaseEntity {

    @Column
    protected String name;

    @Column
    protected Double price;

    @Column
    protected String description;



    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "menuID", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurantOrderID", referencedColumnName = "id")
    private RestaurantOrder restaurantOrder;

    public Item(String name, Double price, String description) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //public Item copy() {
    //    return new Item(name, price, description);
    //}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", menu=" + menu +
                ", restaurantOrder=" + restaurantOrder +
                ", id=" + id +
                '}';
    }
}
