package com.example.demo.controller;


import com.example.demo.model.AbroadTrip;
import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.DomesticTrip;
import com.example.demo.service.TOService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    TOService toService;

    Address address1;
    Address address2;
    Customer customer1;
    Customer customer2;
    DomesticTrip trip1;
    AbroadTrip trip2;

    @Before
    public void setUp() {
        address1 = new Address("Wolności", "128", "Zbirów", "38-109");
        address2 = new Address("Kopernika", "65", "Wąchock", "58-189");
        customer1 = new Customer("Sasha Baron");
        customer2 = new Customer("Justin Bieber");
        customer1.setAddress(address1);
        customer2.setAddress(address2);
        toService.addCustomer(customer1);
        toService.addCustomer(customer2);
        trip1 = new DomesticTrip(LocalDate.of(2019, 2, 28), LocalDate.of(2019, 3, 21), "Wigry");
        trip2 = new AbroadTrip(LocalDate.of(2019, 3, 22), LocalDate.of(2019, 4, 16), "Sri Lanka");
        trip1.setPrice(2500);
        trip2.setPrice(5500);
        toService.addTrip("wig", trip1);
        toService.addTrip("sri", trip2);
    }

    @Test
    public void shouldShowCustomers() throws Exception {
        this.mockMvc.perform(get("/showCustomers"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(customer1.toString())))
                .andExpect(content().string(containsString(customer2.toString())));
    }

    @Test
    public void shouldShowTrips() throws Exception {
        this.mockMvc.perform(get("/showTrips"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(trip1.toString())))
                .andExpect(content().string(containsString(trip2.toString())));
    }

    @Test
    public void addTripFromGET() {
    }

    @Test
    public void addTripFromPOST() {
    }

    @Test
    public void addCustomerFromGET() {
    }

    @Test
    public void addCustomerFromPOST() throws Exception {
        JSONObject customer = new JSONObject();
        JSONObject address = new JSONObject();
        customer.put("name", "Sabina Lorka");
        address.put("street", "Zbiorowa");
        address.put("code", "40-123");
        address.put("city", "Katowice");
        address.put("number", "654");
        customer.put("address", address);
        customer.put("trip", null);

        mockMvc.perform(post("/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customer.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(customer.toString()));
    }

    @Test
    public void findCustomer() {
    }

    @Test
    public void removeCustomer() {
    }

    @Test
    public void removeTrip() {
    }

    @Test
    public void assignTrip() {
    }
}