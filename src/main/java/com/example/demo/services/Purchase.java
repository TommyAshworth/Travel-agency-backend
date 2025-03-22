package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class Purchase {

    //The customer making the purchase.
    private Customer customer;
    //The cart associated with the purchase.
    private Cart cart;
    //The set of cart items included in the purchase.
    private Set<CartItem> cartItems;
}
