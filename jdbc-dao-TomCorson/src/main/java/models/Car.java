package models;

import daos.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Car {
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String vin;

    public Car(){
    }

    public Car(String make, String model, Integer year, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }
    public Car(Integer id, String make, String model, Integer year, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return String.format("ID: %d\nMAKE: %s \nMODEL: %s\nYEAR: %d\nColor %s\nVIN: %s", id, make,model,year,color,vin);
    }
}
