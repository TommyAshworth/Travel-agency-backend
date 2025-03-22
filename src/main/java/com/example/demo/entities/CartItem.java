package com.example.demo.entities;
//import statements
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//class-level annotations
@Entity
@Table(name="cart_items")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Maps id field to the cart_item_id column in the database
    @Column(name="cart_item_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation;

    //Defines a Many to many relationship between CartItem and excursion entities
    @ManyToMany
    @JoinTable(
            name="excursion_cartitem",
            joinColumns=@JoinColumn(name="cart_item_id", nullable = false),
            inverseJoinColumns=@JoinColumn(name="excursion_id", nullable = false)
    )
    //Set to hold excursion objects associated with the cartitem
    private Set<Excursion> excursions = new HashSet<>();

    //Defines a many to one relationship between cartitem and cart entities
    @ManyToOne
    //Specifies the foreign key column in the cart_items table that references cart_id in the cart table
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;

    //Maps the create_date field to the create_date column in database
    @Column(name="create_date", updatable = false)
    //Auto sets the create date to the current timestamp upon entity creation
    @CreationTimestamp
    private Date create_date;

    //Maps the last_update field to the last_update column in the database
    @Column(name="last_update")
    //Automatically updates the last update timestamp whenever the entity is modified
    @UpdateTimestamp
    private Date last_update;
}

