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
@Table(name="countries")
@Getter
@Setter
@NoArgsConstructor
public class Country {

    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Maps the id field to the country_id column in database
    @Column(name="country_id")
    private Long id;

    //Maps the country_name field to the country column in the database
    @Column(name="country")
    private String country_name;

    //Maps the create date field to the create_date column in database
    @Column(name="create_date")
    @CreationTimestamp
    private Date createDate;

    //Maps the lastUpdate field to the last_update column in the database
    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    //Defines a one to many relationship between Country and Division entities
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    //Set to hold division entities associated with this country lazy-loaded and cascading all operations
    private Set<Division> divisions = new HashSet<>();

}
