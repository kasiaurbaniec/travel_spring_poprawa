package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.NoSuchCustomerException;
import com.example.demo.model.NoSuchTripException;
import com.example.demo.model.Trip;

public interface TOService {
    Customer addCustomer();
    Trip addTrip();
    void assign();
    boolean removeCustomer() throws NoSuchCustomerException;
    boolean removeTrip(String id) throws NoSuchTripException;
    String showTrip();
    String showCustomers();
}
