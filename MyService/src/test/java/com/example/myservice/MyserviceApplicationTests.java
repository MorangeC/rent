package com.example.myservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myservice.entities.Car;

@SpringBootTest
class MyserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testCarConstructor() {
		Car car = new Car("ABC123", "Toyota", 15000.0);
		assertEquals("ABC123", car.getPlateNumber());
		assertEquals("Toyota", car.getBrand());
		assertEquals(15000.0, car.getPrice());
	}

}
