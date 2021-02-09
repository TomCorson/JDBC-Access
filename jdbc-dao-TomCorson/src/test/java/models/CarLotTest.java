package models;

import daos.DAO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CarLotTest  {

    @Test
    public void addCarTest(){
        CarLot carLot = new CarLot();
        carLot.addCar(1);
        String expected = "ID: 1\n" +
                "MAKE: Jeep \n" +
                "MODEL: Wrangler\n" +
                "YEAR: 1991\n" +
                "Color black\n" +
                "VIN: updatedVin\n\n";
        String actual = carLot.getCars();
        assertEquals(expected,actual);
    }
    @Test
    public void findAllTest(){
        CarLot carLot = new CarLot();
        List<Car> expected = new ArrayList<Car>();
        expected.add(carLot.findById(1));
        expected.add(carLot.findById(2));
        expected.add(carLot.findById(3));
        expected.add(carLot.findById(4));
        expected.add(carLot.findById(5));
        expected.add(carLot.findById(6));

        List<Car> actual = carLot.findAll();
        for(int i = 0; i < expected.size(); i++){
            assertTrue(expected.get(i).toString().equals(actual.get(i).toString()));
        }
        assertTrue(expected.size() == actual.size());

    }
    @Test
    public void updateTest(){
        CarLot carLot = new CarLot();
        Car car = carLot.findById(2);
        car.setVin("trythisVin");
        assertTrue(carLot.update(car));
    }
    @Test
    public void updateTest2(){
        CarLot carLot = new CarLot();
        Car car = carLot.findById(6);
        car.setColor("Magenta");
        assertTrue(carLot.update(car));
    }


    @Test
    public void createTest(){
        Car car = new Car("Jeep","Liberty",2013,"vinnnnn");
        CarLot carLot = new CarLot();
        assertTrue(carLot.create(car));
    }

}