package com.hritvik.EcommerceAPI.service;

import com.hritvik.EcommerceAPI.model.Address;
import com.hritvik.EcommerceAPI.model.Category;
import com.hritvik.EcommerceAPI.model.Order;
import com.hritvik.EcommerceAPI.model.Product;
import com.hritvik.EcommerceAPI.repository.IProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;
    public Iterable<Product> getAllProduct() {
        return productRepo.findAll();
    }

//    public Iterable<Product> getAllProductbyCategory(Category category) {
//
//        return productRepo.getAllProductOrderByCategory(category);
//    }

    public String addProduct(Product product) {
        productRepo.save(product );
        return "product Added";
    }

    public String DeleteProduct(Long productId) {
        if (productRepo.existsById(productId)) {
            productRepo.deleteById(productId);
            return "product deleted";
        } else {
            return "productId does not exist";
        }
    }
}
