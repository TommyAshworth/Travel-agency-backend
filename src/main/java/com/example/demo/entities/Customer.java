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
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Maps id field to the customer_id column in database
    @Column(name="customer_id", nullable = false)
    private Long id;

    //Maps firstName to the customer_first_name column in database
    @Column(name="customer_first_name", nullable = false)
    private String firstName;

    //Maps the LastName field to the customer_last_name column in database
    @Column(name="customer_last_name", nullable = false)
    private String lastName;

    //Maps the address field to the address column in database
    @Column(name="address", nullable = false)
    private String address;

    //Maps the postal_code field to the postal_code column in database
    @Column(name="postal_code", nullable = false)
    private String postal_code;

    //Maps the phone field to the phone column in database
    @Column(name="phone", nullable = false)
    private String phone;

    //maps the createDate field to the create_date column in database
    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    //Maps the lastUpdate field to the last_update column in database
    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    //Defines ManyToOne relationship between Customer and Division entities
    @ManyToOne
    @JoinColumn(name="division_id", nullable = false, updatable = false)
    private Division division;

    //Defines OneToMany relationship between Customer and cart entities
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    //Method to add a Cart to the customer's cart set
    public void add(Cart cart) {
        carts.add(cart);
    }
}