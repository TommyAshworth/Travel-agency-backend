package com.example.demo;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    //Injecting the repositories for customer and division
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    //Constructor to inject dependencies for customerRepository and division Repository
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Check if there is already exactly one customer in the database
        if (customerRepository.count() == 1) {

            //Creating the first customer and setting their details
            Customer customer1 = new Customer();
            customer1.setFirstName("Alex");
            customer1.setLastName("Martin");
            customer1.setAddress("50 Ocean View Road");
            customer1.setPhone("5551234");
            customer1.setPostal_code("11111");
            customer1.setDivision(divisionRepository.getReferenceById(2L));

            customerRepository.save(customer1);

            //Creating the second customer and setting their details
            Customer customer2 = new Customer();
            customer2.setFirstName("Natalie");
            customer2.setLastName("Brown");
            customer2.setAddress("43 Pinewood Drive");
            customer2.setPhone("5559876");
            customer2.setPostal_code("22222");
            customer2.setDivision(divisionRepository.getReferenceById(67L));

            customerRepository.save(customer2);

            //Creating the third customer and setting their details
            Customer customer3 = new Customer();
            customer3.setFirstName("Sam");
            customer3.setLastName("Harris");
            customer3.setAddress("212 Elm Street");
            customer3.setPhone("5556543");
            customer3.setPostal_code("33333");
            customer3.setDivision(divisionRepository.getReferenceById(3L));

            customerRepository.save(customer3);

            //Creating the fourth customer and setting their details
            Customer customer4 = new Customer();
            customer4.setFirstName("Elena");
            customer4.setLastName("Garcia");
            customer4.setAddress("390 Sunset Blvd");
            customer4.setPhone("5556789");
            customer4.setPostal_code("44444");
            customer4.setDivision(divisionRepository.getReferenceById(12L));

            customerRepository.save(customer4);

            //Creating the fifth customer and setting their details
            Customer customer5 = new Customer();
            customer5.setFirstName("Leonard");
            customer5.setLastName("King");
            customer5.setAddress("210 Oak Street");
            customer5.setPhone("5556789");
            customer5.setPostal_code("55555");
            customer5.setDivision(divisionRepository.getReferenceById(101L));

            customerRepository.save(customer5);
        }
    }
}
