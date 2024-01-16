package com.binary.carShow.repository;

import com.binary.carShow.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Every entity needs it repository!!

@Repository     //add repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
