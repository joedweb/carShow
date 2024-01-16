package com.binary.carShow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})      //so it doest keep looping because of the Json
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;
    private String firstName;
    private String lastName;

    //now to match the other side


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")        //cascade will "also delete all the cars since the owner will be deleted"
    @JsonIgnore             // so it does not Json it (?)
    private List<Car> cars;


    //empty constructor for hibernate. Every entity
    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //One to One            one car per owner
    //Many to One           multiple cars for one owner, multiple owners for one car
    //Many to Many          multiple owners for multiple cars
}
