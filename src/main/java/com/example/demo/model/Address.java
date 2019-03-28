package com.example.demo.model;

public class Address {
    private String street;
    private String city;
    private String code;
    private String number;
    public Address(String street, String number, String city, String code ) {
        this.street = street;
        this.city = city;
        this.code = code;
        this.number = number;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return  street + " " +number+" "+code+" "
               + city;
    }




}
