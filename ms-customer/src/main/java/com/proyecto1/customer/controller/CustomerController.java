package com.proyecto1.customer.controller;

import com.proyecto1.customer.entity.Customer;
import com.proyecto1.customer.service.CustomerService;
import com.proyecto1.customer.service.impl.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger log = LogManager.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @GetMapping("/findAll")
    public Flux<Customer> getCustomers(){
        log.info("Service call findAll - customer");
        return customerService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Customer> getCustomer(@PathVariable String id){
        log.info("Service call findById - customer");
        Mono<Customer> newCustomer = customerService.findById(id);
        return newCustomer;
    }

    @PostMapping("/create")
    public Mono<Customer> createCustomer(@RequestBody Customer c){
        log.info("Service call create - customer");
        Mono<Customer> newCustomer = customerService.create(c);
        return newCustomer;
    }

    @PutMapping("/update/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer c, @PathVariable String id){
        log.info("Service call update - customer");
        return customerService.update(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Customer> deleteCustomer(@PathVariable String id){
        log.info("Service call delete - customer");
                return customerService.delete(id);
    }


}
