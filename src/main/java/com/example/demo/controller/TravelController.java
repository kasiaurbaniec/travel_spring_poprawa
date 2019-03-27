package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {



    @GetMapping("/getCustomer")
    public String getCustomer(){
        return "nowy klient";
    }

}
