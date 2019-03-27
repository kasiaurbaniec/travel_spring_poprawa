package com.example.demo.model;


import java.time.LocalDate;

public class Trip {
    private LocalDate start;
    private LocalDate end;
    private String destination;
    private int price=0;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trip(LocalDate start, LocalDate end, String destination){
        this.start = start;
        this.end = end;
        this.destination = destination;
    }

    public Trip() {
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String toString(){
        return " destination: "+ getDestination()+" from "+start.toString()+" to  "+end.toString()+" price: "+getPrice();
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
