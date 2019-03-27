package com.example.demo.controller;

import com.example.demo.model.Trip;
import com.example.demo.service.TOServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@EnableSwagger2
public class TravelController {

    @Autowired
    private TOServiceImpl toServiceImpl;

    @GetMapping("/showCustomers")
    public String showCustomers(){
        return toServiceImpl.showCustomers();
    }
    @GetMapping("/showtrips")
    public String showTrips(){
        return toServiceImpl.showTrips();
    }
    @GetMapping("/addTrip")
    Trip getTripFromGET(@RequestParam String id,@RequestParam String startDate, @RequestParam String endDate, @RequestParam String desti) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Trip trip = new Trip(LocalDate.parse(startDate,formatter),LocalDate.parse(endDate,formatter),desti);
        return toServiceImpl.addTrip(id,trip);
    }
//    @PostMapping("/addTrip")
//    Trip getPersonFromPOST(@RequestBody Trip trip) {
//        trip.setName(person.getName().toUpperCase());
//        person.setlName(person.getlName().toUpperCase());
//        return person;
//    }
//http://localhost:8080/addTrip?desti=Hawaje&endDate=2017-11-21&id=haw&startDate=2017-12-01
    //http://localhost:8080/addTrip?desti=%27Bali%27&endDate=2018-09-21&id=%27bal%27&startDate=2018-08-01
}
