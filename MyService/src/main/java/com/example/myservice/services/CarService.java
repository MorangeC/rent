package com.example.myservice.services;

import com.example.myservice.entities.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getCar(String plateNumber) {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElse(null);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public boolean updateCar(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPlateNumber().equals(car.getPlateNumber())) {
                cars.set(i, car);
                return true;
            }
        }
        return false;
    }

    public List<Car> getCarsByBrand(String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    public int countCars() {
        return cars.size();
    }
}
