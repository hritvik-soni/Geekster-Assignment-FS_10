package com.hritvik.JobSearchPortal.repository;

import com.hritvik.JobSearchPortal.model.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {


    // using Custom Finder for get jos by title and description
    Iterable<Job> getJobsByTitle(String title); //Custom finder for Get Jobs By Title

    Iterable<Job> getJobsByDescription(String description); //Custom finder for Get Jobs By Description

    Iterable<Job> getJobsByLocation(String location); //Custom finder for Get Jobs By Location


    // using Query for Update and delete

    @Modifying
    @Query("delete from Job j where j.jobId=:id")
    String deleteJob(@Param("id") Long jobId);

    @Modifying
    @Query("update Job j set j.salary = :salary where j.jobId= :id") //
    String updateJobSalary(@Param("id") Long jobId, @Param("salary") Double salary);


}
