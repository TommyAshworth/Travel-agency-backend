package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

//Implementation of the CheckoutService interface.
//Handles the checkout process, including order creating and persistence.

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        //Generates a unique order tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();

        //Associate cart items with the cart
        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        //Sets tracking numbers and updates status
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);

        //Associates cart with customer
        customer.add(cart);

        //Saves carts and customers to the database
        cartRepository.save(cart);
        customerRepository.save(customer);

        //Return responses containing the order tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }

    //Generates a unique order tracking number

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}