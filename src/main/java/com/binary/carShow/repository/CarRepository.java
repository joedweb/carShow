package com.binary.carShow.repository;

import com.binary.carShow.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    //lets you do the CRUD operations!!  <Entity class name, data type>
    //CRUD                              ^JPA also has one!! Similar

    //Rest (Representational State Transfer)
        //is an architectural style to create web services
        //six constraints
            //Stateless: The server does not hold any information about the client state
            // Client and Server:
            // Cacheable:
            // Uniform Interface :
            // Layered System :
            // Code and Demand Option :



    //!!!! What if we need a method that is not on the CRUD? (example: show all cars of make Ford)

    //create another method and stream it and filter it by make (as before)
    //OR
    // easier way.
    //
                 // List<Car> getAllCarByMake(String make);     Spring Boot will recognize and provide the implementation!!


    List<Car> getAllCarByMake(String make);

    //make another one Make and Model!! for example will  have two      (String make, String make)

    List<Car> getCarByMakeAndModel(String make, String model);     //non-order
    List<Car> findCarByMakeAndModelOrderByYear(String make, String model);      //ordered by year
}
