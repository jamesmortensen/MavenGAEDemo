package com.setmore.myapp;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Car {
    @Id Long id;
    String vin;
    int color;
    byte[] rawData;
    //@Ignore irrelevant;

    private Car() {}

    public Car(String vin, int color) {
        this.vin = vin;
        this.color = color;
    }
}