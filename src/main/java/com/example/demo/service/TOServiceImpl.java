package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
@Service
public class TOServiceImpl {
//    public TOService(TravelOffice to) {
//        this.to = to;
//    }

    public String showTrips() {
        return to.showTrips();
    }
    public Map<String, Trip> getMapOfTrips(){
        return to.getMapOfTrips();
    }
    public Set<Customer> getSetOfCustomers(){
        return to.getSetOfCustomers();
    }
    TravelOffice to=new TravelOffice();

    public String showCustomers(){
        return to.showCustomers();
    }
    public Trip addTrip(String id, Trip trip){
        to.addTrip(id,trip);
        return trip;
    }
    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        return to.findCustomerByName(name);
    }

    public boolean removeTrip(String id) throws NoSuchTripException {
        return to.removeTrip(id);
    }
    public void addCustomer(Customer customer) {
        to.addCustomer(customer);
    }
    public boolean customerInSetChecker(String name){
        return to.customerInSetChecker(name);
    }
}
