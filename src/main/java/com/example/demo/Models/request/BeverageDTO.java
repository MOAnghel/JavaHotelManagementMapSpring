package com.example.demo.Models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BeverageDTO {

    private String name;

    private Double price;

    private String description;

    private Integer volume;

    private Integer alcoholPercentage;
}
