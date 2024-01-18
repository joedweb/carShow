package com.binary.carShow.service;

import com.binary.carShow.entity.Car;
import com.binary.carShow.entity.Owner;
import com.binary.carShow.exception.ResourceNotFoundException;
import com.binary.carShow.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }else{
            throw new ResourceNotFoundException("Owner with id: " + id + " not found");
    }
//Optional: is a container object used to represent a value that may or may not be present
    }

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner updateOwnerById(Long id, Owner owner) {

        //check if it's present first. We made a method for this already.
        Owner existingOwner = getOwnerById(id);

        //update if found
        existingOwner.setFirstName(owner.getFirstName());
        existingOwner.setLastName(owner.getLastName());

       ownerRepository.save(existingOwner);
       return existingOwner;
    }

}
