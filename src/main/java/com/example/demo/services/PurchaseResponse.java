package com.example.demo.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseResponse {


    //Unique tracking number assigned to the order.
    private String orderTrackingNumber;
}