package com.example.demo.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice {
    private Set<Customer> setOfCustomers = new HashSet<>();
    private Map<String, Trip> mapOfTrips = new HashMap<>();

    public Set<Customer> getSetOfCustomers() {
        return setOfCustomers;
    }

    public Map<String, Trip> getMapOfTrips() {
        return mapOfTrips;
    }

    public void addCustomer(Customer customer) {
        setOfCustomers.add(customer);
    }

    public int getCustomerCount() {
        return setOfCustomers.size();
    }

    public String toString() {
        return "Customers: " + setOfCustomers.toString() + "\n" + "Trips: " + mapOfTrips.values().toString();
    }

    public String showTrips() {
        StringBuilder trips = new StringBuilder();
        if (mapOfTrips.isEmpty()) {
            return "List of trips is empty";
        } else
            System.out.println("All trips: ");
        mapOfTrips.entrySet().forEach(x -> trips.append(x.getKey() + " " + x.getValue() + "\n"));
        return "All trips: " + trips;
    }

    public String showCustomers() {
        StringBuilder customers = new StringBuilder();
        if (setOfCustomers.isEmpty()) {
            return "list of customers is empty";
        } else
            setOfCustomers.forEach(x -> customers.append(x.toString() + "\n"));
        return "customers" + customers;


    }

    public Trip addTrip(String id, Trip trip) {
        mapOfTrips.put(id, trip);
        return trip;
    }

    public boolean removeTrip(String id) throws NoSuchTripException {
        if (mapOfTrips.containsKey(id)) {
            mapOfTrips.remove(id);
            return true;
        }
        throw new NoSuchTripException("no such trip");
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        for (Customer c : setOfCustomers) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                return c;
            }
        }
        throw new NoSuchCustomerException("no such customer");
    }

    public boolean removeCustomer(Customer customer) throws NoSuchCustomerException{
        if (setOfCustomers.contains(customer)) {
            setOfCustomers.remove(customer);
            return true;
        }
        throw new NoSuchCustomerException("no such customer");
    }

    public boolean customerInSetChecker(String name) {
        for (Customer cust : getSetOfCustomers()
        ) {
            if (cust.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }
}





