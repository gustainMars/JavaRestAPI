package com.products.apirest.repository;

import com.products.apirest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    Product findById(long id);

}