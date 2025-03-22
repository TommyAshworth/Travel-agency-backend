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
@Table(name="vacations")
@Getter
@Setter
@NoArgsConstructor
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Maps the id field to the vacation_id column in database
    @Column(name="vacation_id", nullable = false)
    private Long id;

    //Maps the vacation_title field to the vacation_title column in database
    @Column(name="vacation_title", nullable = false)
    private String vacation_title;

    //Maps the description field to the description column in database
    @Column(name="description", nullable = false)
    private String description;

    //Maps the travel_price field to the travel_fare_price column in database
    @Column(name="travel_fare_price", nullable = false)
    private BigDecimal travel_price;

    //Maps the image_URL field to the image_url column in database
    @Column(name="image_url", nullable = false)
    private String image_URL;

    //Maps the create_date field to the create_date column in the database

    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    //Maps last_update field to the last_update column in database
    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    //Defines a OneToMany relationship with Excursion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation_title")
    //Set to hold Excursions associated with this Vacation
    private Set<Excursion> excursions = new HashSet<>();
}