package com.binary.carShow.webController;

import com.binary.carShow.entity.Car;
import com.binary.carShow.entity.Owner;
import com.binary.carShow.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners(){
        return new ResponseEntity<>(ownerService.getOwners(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id){
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.addOwner(owner), HttpStatus.CREATED);       // CREATED = 201
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Owner> deleteOwnerById(@PathVariable Long id){
        ownerService.deleteOwnerById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwnerById(@PathVariable Long id, @RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.updateOwnerById(id,owner),HttpStatus.ACCEPTED);
    }
}
