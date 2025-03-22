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
@Table(name="excursions")
@Getter
@Setter
@NoArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Maps id field to the excursion_id column in database
    @Column(name="excursion_id", nullable = false)
    private Long id;

    //Maps excursion_title field to the excursion_title column in database
    @Column(name="excursion_title", nullable = false)
    private String excursion_title;

    //Maps excursion_price field to the  excursion_price column in database
    @Column(name="excursion_price", nullable = false)
    private BigDecimal excursion_price;

    //Maps image_URL field to the image_url column in database
    @Column(name="image_url", nullable = false)
    private String image_URL;

    //Maps create_date field to the create_date column in database
    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    //Maps last_update field to the last_update column in database
    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    //Defines a Many to one relationship between excursion and vacation entities
    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation_title;

    //Defines a Many to many relationship between excursion and cartitem entities
    @ManyToMany
    @JoinTable(
            name="excursion_cartitem",
            joinColumns=@JoinColumn(name="excursion_id", nullable = false),
            inverseJoinColumns=@JoinColumn(name="cart_item_id", nullable = false)
    )
    private Set<CartItem> cartItems = new HashSet<>();
}