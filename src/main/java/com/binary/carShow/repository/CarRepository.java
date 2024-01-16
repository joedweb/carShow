package com.binary.carShow.repository;

import com.binary.carShow.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {      //lets you do the CRUD operations!!  <Entity class name, data type>
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

}
