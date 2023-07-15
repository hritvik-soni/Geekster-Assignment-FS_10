package com.hritvik.MappingPracticeAssignment.repository;

import com.hritvik.MappingPracticeAssignment.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Long> {
}
