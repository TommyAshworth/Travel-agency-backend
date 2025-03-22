package com.example.demo.entities;

//import statements
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//class-level annotations
@Entity
@Table(name="carts")
@Getter
@Setter
@NoArgsConstructor
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //maps the id field for cart_id column in the database
    @Column(name="cart_id")
    private Long id;

    //maps the ordertrackingnumber field to the ordertracking number column
    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    //maps the package_price field to the package_price column
    @Column(name="package_price")
    private BigDecimal package_price;

    //maps the party_size field to the party_size column
    @Column(name="party_size")
    private int party_size;

    //maps the status field to the status column
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    //maps create_date field to the create_date column
    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    //maps last_update field to the last_update column
    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    //Defines a ManyToOne relationship between cart and customer entities
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    //Defines a OneToMany relationship with CartItem
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    //Method to add an item to the cart
    public void add(CartItem item) {
        //Adds a cartItem to the carts cartItems set
        this.cartItems.add(item);
    }
}
