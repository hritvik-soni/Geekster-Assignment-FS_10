package com.hritvik.UniversityEventManagement.repository;

import com.hritvik.UniversityEventManagement.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepo extends CrudRepository <Event,Long> {

}
