package com.binary.carShow.service;

import com.binary.carShow.entity.Car;
import com.binary.carShow.exception.ResourceNotFoundException;
import com.binary.carShow.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service                //if we dont do this we cant inject it on the controller
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;        //need to be able to talk to the repository (the data)

    public CarServiceImpl(CarRepository carRepository) {             //injected it by the constructor. Can't use @Autowired because it's final.
        this.carRepository = carRepository;                                 // Both work but the field injection (constructor) is more safe
    }

    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();         //returns iterable so had to cast it as a list
    }


    @Override
    public Car getCarById(Long id) {            //when giving the id it may or may not exist on the table so
//it's an optional, so we have to check if present, if not throw an exception
        //Optional: is a container object used to represent a value that may or may not be present

        //
        Optional<Car> optionalCar = carRepository.findById(id);
            if(optionalCar.isPresent()){
                return optionalCar.get();       //if present get the object
            } else{
                throw new ResourceNotFoundException("Car with id " + id + " not found");      //if not present throw exception
            }
        //

        //Can also do with Java 8:
            // return carRepository.findById(id)
            //.orElseThrow(()-> new ResourceNotFoundException("Car with id: " +id+ " not found"));
    }

    @Override
    public Car addCar( Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);       //would work but it won't check for presence
    }

    @Override
    public Car updateCarById(Long id, Car car) {

        //check if it's present first. We made a method for this already.
        Car existingCar = getCarById(id);           //covers optional already

        existingCar.setMake(car.getMake());
        existingCar.setModel(car.getModel());
        existingCar.setColor(car.getColor());
        existingCar.setRegisterNumber(car.getRegisterNumber());
        existingCar.setYear(car.getYear());
        existingCar.setPrice(car.getPrice());

        carRepository.save(existingCar);
        return existingCar;
    }

    @Override
    public List<Car> getCarByMake(String make) {
        return carRepository.getAllCarByMake(make);
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        return carRepository.getCarByMakeAndModel(make,model);
    }

}
