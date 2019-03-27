package com.example.demo.service;

import com.example.demo.model.*;

import java.util.Map;
import java.util.Set;

public interface TOService {
    public String showTrips();
    public Map<String, Trip> getMapOfTrips();

    public Set<Customer> getSetOfCustomers();


    public String showCustomers();

    public Trip addTrip(String id, Trip trip);
    public Customer findCustomerByName(String name) throws NoSuchCustomerException ;


    public boolean removeTrip(String id) throws NoSuchTripException ;
    public Customer addCustomer(Customer customer) ;
    public boolean customerInSetChecker(String name);
}
