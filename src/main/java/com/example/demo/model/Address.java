package com.example.demo.model;

public class Address {
    private String street;
    private String City;
    private String code;

    public Address(String street, String number, String city, String code ) {
        this.street = street;
        City = city;
        this.code = code;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return City;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return  street + ' ' +number+" "+code+" "
               + City;
    }



    private String number;
}
