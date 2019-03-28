package com.example.demo.model;

public class Customer {
private String name;
private Address address;
private Trip trip=null;

    public Customer(String name) {
        this.name = name;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        if(trip==null){
            return "\nname: "+name+" \ntrip: null"+" \naddress: "+address.toString()+"\n";
        }else{
                    return "\nname: "+name+" \ntrip: "+trip.toString()+" \naddress: "+address.toString()+"\n";}}

    public Address getAddress() {
        return address;
    }

    public Trip getTrip() {
        return trip;
    }
}
