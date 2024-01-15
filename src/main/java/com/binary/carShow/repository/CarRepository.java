package com.binary.carShow.repository;

import com.binary.carShow.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {         //lets you do the CRUD operations!!      <Class, id data type>
    //CRUD                              ^JPA also has one!! Similar


}
