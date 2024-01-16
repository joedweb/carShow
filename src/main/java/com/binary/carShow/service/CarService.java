package com.binary.carShow.service;

import com.binary.carShow.entity.Car;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    Car getCarById(Long id);

    //added

    Car addCar(Car car);

    void deleteCarById(Long id);

    Car updateCarById(Long id, Car car);
}
