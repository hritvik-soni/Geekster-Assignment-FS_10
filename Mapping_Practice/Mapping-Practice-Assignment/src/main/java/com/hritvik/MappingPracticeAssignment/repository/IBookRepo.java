package com.hritvik.MappingPracticeAssignment.repository;

import com.hritvik.MappingPracticeAssignment.model.Address;
import com.hritvik.MappingPracticeAssignment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Long> {
}
