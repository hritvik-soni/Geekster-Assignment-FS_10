package com.hritvik.EcommerceAPI.repository;

import com.hritvik.EcommerceAPI.model.Category;
import com.hritvik.EcommerceAPI.model.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends CrudRepository<Product,Long> {

    @Query(value ="select * from Product where Product_Category =:category",nativeQuery=true)
    Iterable<Product> getAllProductbyCategory(String category);
}
