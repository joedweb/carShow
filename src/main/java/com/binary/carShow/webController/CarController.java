package com.binary.carShow.webController;

import com.binary.carShow.entity.Car;
import com.binary.carShow.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController             // Controller + Response Body   !!
@RequestMapping("/api/v1/car")
public class CarController {
 private final CarService carService;         //"create an object of Carservice so we can use it"

    public CarController(CarService carService) {           //field injection! preferred than using @Autowired. Needed here since made final
        this.carService = carService;
    }


    //CHANGED 1/16          ?????

    @GetMapping("/cars")         //Get because it's reading!1
    public ResponseEntity<List<Car>> getCars(){
       return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);    //200
   }

   //added 1/16
    @GetMapping("/{id}")
   public ResponseEntity <Car> getCarById(@PathVariable Long id){
        return new ResponseEntity<>(carService.getCarById(id),HttpStatus.OK);
   }
//Http method indicates the action of an api client should
    //100s continue
    //200s is OK. Successful
    //300s Redirection
    //400s something went wrong. Client error, bad requests, unauthorized, etc.
    //500s server error


    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);       // CREATED = 201
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long id){

        carService.deleteCarById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);           //accepts to delete
    }


    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable Long id, @RequestBody Car car){
        return new ResponseEntity<>(carService.updateCarById(id,car), HttpStatus.ACCEPTED);
    }


}
