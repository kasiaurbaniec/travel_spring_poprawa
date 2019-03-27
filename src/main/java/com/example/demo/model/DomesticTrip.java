package com.example.demo.model;


import java.time.LocalDate;

public class DomesticTrip extends Trip {
    int ownArrivalDiscount=400;

    public void setOwnArrivalDiscount(int ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }



    @Override
    public int getPrice() {
        return super.getPrice()-ownArrivalDiscount;
    }

    public DomesticTrip(LocalDate start, LocalDate end, String desctription) {
        super(start, end, desctription);
    }
}
