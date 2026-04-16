package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarConstructor() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        assertEquals("ABC123", car.getPlateNumber());
        assertEquals("Toyota", car.getBrand());
        assertEquals(15000.0, car.getPrice());
    }

    @Test
    public void testSetPlateNumber() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        car.setPlateNumber("XYZ789");
        assertEquals("XYZ789", car.getPlateNumber());
    }

    @Test
    public void testSetBrand() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        car.setBrand("Honda");
        assertEquals("Honda", car.getBrand());
    }

    @Test
    public void testSetPrice() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        car.setPrice(20000.0);
        assertEquals(20000.0, car.getPrice());
    }

    @Test
    public void testToString() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        String expected = "Car{plateNumber='ABC123', brand='Toyota', price=15000.0}";
        assertEquals(expected, car.toString());
    }

    @Test
    public void testEqualsSamePlateNumber() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("ABC123", "Honda", 18000.0);
        assertTrue(car1.equals(car2));
    }

    @Test
    public void testEqualsDifferentPlateNumber() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("XYZ789", "Toyota", 15000.0);
        assertFalse(car1.equals(car2));
    }

    @Test
    public void testEqualsNull() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        assertFalse(car.equals(null));
    }

    @Test
    public void testHashCodeConsistent() {
        Car car1 = new Car("ABC123", "Toyota", 15000.0);
        Car car2 = new Car("ABC123", "Honda", 18000.0);
        assertEquals(car1.hashCode(), car2.hashCode());
    }

    @Test
    public void testApplyDiscountValid() {
        Car car = new Car("ABC123", "Toyota", 100.0);
        assertEquals(90.0, car.applyDiscount(10), 0.01);
    }

    @Test
    public void testApplyDiscountZero() {
        Car car = new Car("ABC123", "Toyota", 100.0);
        assertEquals(100.0, car.applyDiscount(0), 0.01);
    }

    @Test
    public void testApplyDiscountHundred() {
        Car car = new Car("ABC123", "Toyota", 100.0);
        assertEquals(0.0, car.applyDiscount(100), 0.01);
    }

    @Test
    public void testApplyDiscountInvalidNegative() {
        Car car = new Car("ABC123", "Toyota", 100.0);
        assertThrows(IllegalArgumentException.class, () -> car.applyDiscount(-10));
    }

    @Test
    public void testApplyDiscountInvalidOverHundred() {
        Car car = new Car("ABC123", "Toyota", 100.0);
        assertThrows(IllegalArgumentException.class, () -> car.applyDiscount(150));
    }
}
