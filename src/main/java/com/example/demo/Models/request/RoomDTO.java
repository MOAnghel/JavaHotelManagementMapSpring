package com.example.demo.Models.request;

import com.example.demo.Models.Enums.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {

    private Integer roomNumber;


    private RoomCategory roomCategory;


    private Integer numberOfBeds;


    private boolean occupied;


    private Integer price;
}
