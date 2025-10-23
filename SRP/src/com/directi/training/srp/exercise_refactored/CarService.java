package com.directi.training.srp.exercise_refactored;

import java.util.List;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public String getCarsNames() {
        StringBuilder sb = new StringBuilder();
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            sb.append(car.getBrand()).append(" ").append(car.getModel()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }

    public Car getBestCar() {
        List<Car> cars = carRepository.getAllCars();
        Car bestCar = null;
        for (Car car : cars) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
