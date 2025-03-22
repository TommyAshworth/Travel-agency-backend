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
@Table(name="divisions")
@Getter
@Setter
@NoArgsConstructor
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Maps the id field to the division_id column in database
    @Column(name="division_id", nullable = false)
    private Long id;

    //Maps division_name field to the division column in database
    @Column(name="division", nullable = false)
    private String division_name;

    //Maps the createDate field to the create_date column in database
    @Column(name="create_date")
    //Auto sets create date to the current timestamp upon entity creation
    @CreationTimestamp
    private Date createDate;

    //Maps the lastUpdate field to the last_update column in the database
    @Column(name="last_update", updatable = false)
    @UpdateTimestamp
    private Date lastUpdate;

    //Defines ManyToOne relationship between division and country entities
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    //Maps the country_id field to the country_id column in database.
    @Column(name="country_id", nullable = false)
    private Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    //Defines OneToMany relationship between Division and Customer entities
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();
}