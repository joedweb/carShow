package com.binary.carShow.entity;

import jakarta.persistence.*;

import javax.swing.*;
@Entity         ///first thing to do when making a table in the relational database!
public class Car {

    @Id                                                     // identifies our primary key
    @GeneratedValue(strategy = GenerationType.AUTO)         //for the auto generated ids incrementing. AUTO keyword looks for the best strategy of implementtation
    private Long id;                        // .IDENTITY will let you work with SQL and other databases together, .SEQUENCE would let you use an increment pattern


    //@Column(name = "Brand")       to change a column's name
    private String make;
    private String model;
    private String color;
    private String registerNumber;
    private int year;
    private double price;

    //---------------------------------------

    // EVERY Entity needs an empty constructor. HIBERNATE will use it
    public Car() {
    }

    public Car( String make, String model, String color, String registerNumber, int year, double price) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
