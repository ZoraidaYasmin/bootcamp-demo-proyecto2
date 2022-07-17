package com.proyecto1.product.controller;

import com.proyecto1.product.entity.Product;
import com.proyecto1.product.service.ProductService;
import com.proyecto1.product.service.impl.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LogManager.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public Flux<Product> getCustomers(){
        log.info("Service call FindAll - product");
        return productService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Product> getCustomer(@PathVariable String id){
        log.info("Service call FindById - product");
        Mono<Product> newCustomer = productService.findById(id);
        return newCustomer;
    }

    @PostMapping("/create")
    public Mono<Product> createCustomer(@RequestBody Product p){
        log.info("Service call create - product");
        Mono<Product> newCustomer = productService.create(p);
        return newCustomer;
    }

    @PutMapping("/update/{id}")
    public Mono<Product> updateCustomer(@RequestBody Product p, @PathVariable String id){
        log.info("Service call Update - product");
        return productService.update(p,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Product> deleteCustomer(@PathVariable String id){
        log.info("Service call delete - Product");
        return productService.delete(id);
    }

}
