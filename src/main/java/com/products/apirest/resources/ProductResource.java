package com.products.apirest.resources;

import java.util.List;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // Defines that this class will receive HTTP requests
@RequestMapping(value = "/api") // Define the standard URI
public class ProductResource {

    @Autowired
    ProductRepository repository;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return repository.findAll();
    }

    @GetMapping("/product/{id}") 
    public Product listProduct(@PathVariable(value="id") long id) {
        return repository.findById(id);        
    }

    @PostMapping(value="/product")
    public Product saveProduct(@RequestBody Product product) {
        return repository.save(product);
    }
    
}