package com.example.myservice.controllers;

import com.example.myservice.entities.Car;
import com.example.myservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RentServiceRest {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carService.getCars();
    }

    @GetMapping("/cars/{plateNumber}")
    public Car getCar(@PathVariable String plateNumber){
        return carService.getCar(plateNumber);
    }

    @DeleteMapping("/cars")
    public void deleteCar(@RequestBody Car car){
        carService.deleteCar(car);
    }

    @PutMapping("/cars")
    public boolean updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @GetMapping("/cars/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand){
        return carService.getCarsByBrand(brand);
    }

    @GetMapping("/cars/count")
    public int getCarsCount(){
        return carService.countCars();
    }

}
