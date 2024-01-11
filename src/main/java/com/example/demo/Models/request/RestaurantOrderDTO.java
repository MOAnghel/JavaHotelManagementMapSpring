package com.example.demo.Models.request;

import com.example.demo.Models.Enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantOrderDTO {

    private PaymentMethod paymentMethod;

}
