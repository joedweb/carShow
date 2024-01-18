package com.binary.carShow.service;

import com.binary.carShow.entity.Car;
import com.binary.carShow.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getOwners();

    Owner getOwnerById(Long id);

    Owner addOwner(Owner owner);

    void deleteOwnerById(Long id);

    Owner updateOwnerById(Long id, Owner owner);
}
