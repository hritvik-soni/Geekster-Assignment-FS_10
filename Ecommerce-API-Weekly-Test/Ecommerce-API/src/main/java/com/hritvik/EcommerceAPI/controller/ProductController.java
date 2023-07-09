package com.hritvik.EcommerceAPI.controller;

import com.hritvik.EcommerceAPI.model.Address;
import com.hritvik.EcommerceAPI.model.Category;
import com.hritvik.EcommerceAPI.model.Order;
import com.hritvik.EcommerceAPI.model.Product;
import com.hritvik.EcommerceAPI.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("product")
    public Iterable<Product> getAllProduct(){
        return productService.getAllProduct();
    }


//    @GetMapping("productwithcategory")
//    public Iterable<Product> getProductbyCategory(@RequestParam("category")Category category)
//    {
//        return productService.getAllProductbyCategory(category);
//    }

    @PostMapping("product")
    public String addProduct(@RequestBody @Valid Product product)
    {
        return productService.addProduct(product);
    }

    @DeleteMapping("product")

    public String DeleteProduct(@RequestParam("id") Long productId)
    {
        return productService.DeleteProduct(productId);
    }

}
