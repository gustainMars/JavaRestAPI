package com.products.apirest.resources;

import java.util.List;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // Defines that this class will receive HTTP requests
@RequestMapping(value = "/api") // Define the standard URI
@Api(value="REST API Products")
@CrossOrigin(origins="*") //Specifies wich domain can access this API
public class ProductResource {

    @Autowired
    ProductRepository repository;

    @GetMapping("/products")
    @ApiOperation(value="Returns a list of all products")
    public List<Product> listProducts() {
        return repository.findAll();
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value="Returns the product with specified id in URL") 
    public Product listProduct(@PathVariable(value="id") long id) {
        return repository.findById(id);        
    }

    @PostMapping(value="/product")
    @ApiOperation(value="Save a product on database") 
    public Product saveProduct(@RequestBody Product product) {
        return repository.save(product);
    }
    
    /* Implementation carried out in the course. 
    However, I believe that it would be a best practice 
    to request the id and, through it, the method to effect 
    the deletion.

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product) {
        repository.delete(product);
    } 
    */

    @DeleteMapping("/product/{id}")
    @ApiOperation(value="Deletes the product with specified id in URL") 
    public void deleteProduct(@PathVariable(value="id") long id) {
        Product product = new Product();
        product.setId(id);
        repository.delete(product);
    } 

    @PutMapping("/product")
    @ApiOperation(value="Updates the product if the given id on the requisition body exists in the database")  
    public Product updateProduct(@RequestBody Product product) {
        return repository.save(product);        
    }
}