package com.example.myservice.services;

import com.example.myservice.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        assertEquals(1, carService.getCars().size());
    }

    @Test
    public void testGetCars() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("XYZ789", "Honda", 18000.0);
        carService.addCar(car1);
        carService.addCar(car2);
        assertEquals(2, carService.getCars().size());
    }

    @Test
    public void testGetCarByPlateNumber() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        Car result = carService.getCar("ABC123");
        assertNotNull(result);
        assertEquals("ABC123", result.getPlateNumber());
        assertEquals("Toyota", result.getBrand());
    }

    @Test
    public void testGetCarNotFound() {
        Car result = carService.getCar("NOTFOUND");
        assertNull(result);
    }

    @Test
    public void testAddMultipleCars() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("XYZ789", "Honda", 18000.0);
        Car car3 = new Car("DEF456", "Ford", 20000.0);
        
        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        
        assertEquals(3, carService.getCars().size());
    }

    @Test
    public void testUpdateCar() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car1);
        
        Car carUpdated = new Car("ABC123", "Toyota", 20000.0);
        boolean result = carService.updateCar(carUpdated);
        
        assertTrue(result);
        assertEquals(20000.0, carService.getCar("ABC123").getPrice());
    }

    @Test
    public void testUpdateCarNotFound() {
        Car car = new Car("NOTFOUND", "Toyota", 15000.0);
        boolean result = carService.updateCar(car);
        assertFalse(result);
    }

    @Test
    public void testGetCarsByBrand() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("XYZ789", "Honda", 18000.0);
        Car car3 = new Car("DEF456", "Toyota", 20000.0);
        
        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        
        List<Car> toyotaCars = carService.getCarsByBrand("Toyota");
        assertEquals(2, toyotaCars.size());
    }

    @Test
    public void testGetCarsByBrandCaseInsensitive() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        
        List<Car> result = carService.getCarsByBrand("toyota");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetCarsByBrandNotFound() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        
        List<Car> result = carService.getCarsByBrand("BMW");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCountCars() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("XYZ789", "Honda", 18000.0);
        
        carService.addCar(car1);
        assertEquals(1, carService.countCars());
        
        carService.addCar(car2);
        assertEquals(2, carService.countCars());
    }
}
