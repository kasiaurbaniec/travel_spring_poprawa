package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.NoSuchCustomerException;
import com.example.demo.model.Trip;
import com.example.demo.service.TOServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@EnableSwagger2
public class TravelController {

    @Autowired
    private TOServiceImpl toServiceImpl;

    @GetMapping("/showCustomers")
    public String showCustomers() {
        return toServiceImpl.showCustomers();
    }

    @GetMapping("/showTrips")
    public String showTrips() {
        return toServiceImpl.showTrips();
    }

//    @GetMapping("/addTrip")
//    Trip addTripFromGET(@RequestParam String id, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String desti,
//                        @RequestParam int price) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        Trip trip = new Trip(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter), desti);
//        trip.setPrice(price);
//        return toServiceImpl.addTrip(id, trip);
//    }

    @PostMapping("/addTrip")
    Trip addTripFromPOST(@RequestBody Trip trip) {
        trip.setStart(trip.getStart());
        trip.setEnd(trip.getEnd());
        trip.setDestination(trip.getDestination().toUpperCase());
        trip.setPrice(trip.getPrice());
        return toServiceImpl.addTrip(trip.getDestination().toLowerCase().substring(0, 3), trip);
    }



    @GetMapping("/addCustomer")
    Customer addCustomerFromGet(@RequestParam String name, @RequestParam String city, @RequestParam String code, @RequestParam String street,
                                 @RequestParam String streetNumber) {
        Customer customer = new Customer(name);
        Address address = new Address(street, streetNumber, city, code);
        customer.setAddress(address);
        customer.assignTrip(null);
        toServiceImpl.addCustomer(customer);
        return customer;
    }

    @PostMapping ("/addCustomer")
    Customer addCustomerFromPOST(Customer customer) {
        customer.setName(customer.getName());
        customer.setAddress(customer.getAddress());
        customer.assignTrip(null);
        toServiceImpl.addCustomer(customer);
        return customer;
    }
    @PostMapping ("/findCustomerByName")
    Customer findCustomer(@RequestParam String name) {
        return toServiceImpl.findCustomerByName(name);
    }

    @PostMapping("/removeCustomer")
    boolean removeCustomer(@RequestParam String name) {
        Customer customer = toServiceImpl.findCustomerByName(name);
        return toServiceImpl.removeCustomer(customer);
    }

    @PostMapping("/removeTrip")
    boolean removeTrip(@RequestParam String id) {
        return toServiceImpl.removeTrip(id);
    }

    @PostMapping("/assignTrip")
    boolean assignTrip(@RequestParam String id, @RequestParam String name) {
        return toServiceImpl.assignTrip(name, id);
    }


    //http://localhost:8080/swagger-ui.html

}
