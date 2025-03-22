package com.example.demo.services;

/*
Interface for the checkout service.
Defines the contract for processing an order.
*/
public interface CheckoutService {

    /*
       Places an order based on the provided purchase details
    */
    PurchaseResponse placeOrder(Purchase purchase);
}
