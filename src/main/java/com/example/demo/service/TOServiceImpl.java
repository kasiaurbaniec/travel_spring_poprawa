package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class TOServiceImpl implements TOService {

    public String showTrips() {
        return to.showTrips();
    }

    public Map<String, Trip> getMapOfTrips() {
        return to.getMapOfTrips();
    }

    public Set<Customer> getSetOfCustomers() {
        return to.getSetOfCustomers();
    }

    TravelOffice to = new TravelOffice();

    public String showCustomers() {
        return to.showCustomers();
    }

    public Trip addTrip(String id, Trip trip) {
        to.addTrip(id, trip);
        return trip;
    }

    public Customer findCustomerByName(String name) {
        try {
            return to.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            e.getMessage();
            return null;
        }
    }

    public boolean removeTrip(String id) {
        try {
            return to.removeTrip(id);
        } catch (NoSuchTripException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean removeCustomer(Customer customer) {
        try {
            return to.removeCustomer(customer);
        } catch (NoSuchCustomerException e) {
            e.getMessage();
            return false;
        }
    }

    public Customer addCustomer(Customer customer) {
        to.addCustomer(customer);
        return customer;
    }

    public boolean customerInSetChecker(String name) {

        return to.customerInSetChecker(name);
    }

    public boolean assignTrip(String name, String tripID) {
        Customer customer = findCustomerByName(name);
        if (getMapOfTrips().containsKey(tripID)) {
            Trip trip = getMapOfTrips().get(tripID);
            customer.assignTrip(trip);
            return true;
        } else return false;
    }
}
