package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.NoSuchCustomerException;
import com.example.demo.model.Trip;
import com.example.demo.service.TOServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @GetMapping("/showtrips")
    public String showTrips() {
        return toServiceImpl.showTrips();
    }

    @GetMapping("/addTrip")
    Trip getTripFromGET(@RequestParam String id, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String desti,
                        @RequestParam int price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Trip trip = new Trip(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter), desti);
        trip.setPrice(price);
        return toServiceImpl.addTrip(id, trip);
    }

    @PostMapping("/addTrip")
    Trip getTripFromPOST(@RequestBody Trip trip) {
        trip.setStart(trip.getStart());
        trip.setEnd(trip.getEnd());
        trip.setDestination(trip.getDestination().toUpperCase());
        trip.setPrice(trip.getPrice());
        return toServiceImpl.addTrip(trip.getDestination().toLowerCase().substring(0, 3), trip);
    }

    @GetMapping("/addCustomer")
    Customer getCustomerFromGET(@RequestParam String name, @RequestParam String city, @RequestParam String code, @RequestParam String street,
                                @RequestParam String streetNumber) {
        Address address = new Address(street, streetNumber, city, code);
        Customer customer = new Customer(name);
        customer.setAddress(address);
        customer.assignTrip(null);
        return toServiceImpl.addCustomer(customer);
    }

    @PostMapping("/addCustomer")
    Customer getCustomerFromPOST(Customer customer) {
            customer.setName(customer.getName());
            customer.setAddress(customer.getAddress());
            customer.assignTrip(customer.getTrip());
            return toServiceImpl.addCustomer(customer);
    }

    @GetMapping("/findCustomerByName")
   Customer findCustomer(String name) throws NoSuchCustomerException {
        return toServiceImpl.findCustomerByName(name);
    }
//localhost:8080/addCustomer?name='Kasia'&city='Katowice'&code='30-454'&street='Gorzka'&streetNumber='32'

    //http://localhost:8080/swagger-ui.html

}
