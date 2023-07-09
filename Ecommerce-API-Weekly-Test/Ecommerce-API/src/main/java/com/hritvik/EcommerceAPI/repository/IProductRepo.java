package com.hritvik.EcommerceAPI.repository;

import com.hritvik.EcommerceAPI.model.Category;
import com.hritvik.EcommerceAPI.model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends CrudRepository<Product,Long> {
//    Iterable<Product> getAllProductOrderByCategory(Category category);
}
