package com.example.demo.Models.request;

import com.example.demo.Models.Enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodDTO {
    private String name;

    private Double price;

    private String description;

    private Integer quantity;

    private Integer spiceLevel;

    private FoodType foodType;
}
