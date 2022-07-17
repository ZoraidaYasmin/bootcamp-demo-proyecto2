package com.proyecto1.signatory.controller;

import com.proyecto1.signatory.entity.Signatory;
import com.proyecto1.signatory.service.SignatoryService;

import com.proyecto1.signatory.service.impl.SignatoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/signatory")
public class SignatoryController {
    private static final Logger log = LogManager.getLogger(SignatoryController.class);
    @Autowired
    private SignatoryService signatoryService;

    @GetMapping("/findAll")
    public Flux<Signatory> getSignatories(){
        log.info("Service call FindAll - signatory");
        return signatoryService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Signatory> getSignatory(@PathVariable String id){
        log.info("Service call FindById - signatory");
        Mono<Signatory> newDeposit = signatoryService.findById(id);
        return newDeposit;
    }

    @PostMapping("/create")
    public Mono<Signatory> createSignatory(@RequestBody Signatory c){
        log.info("Service call Create - signatory");
        Mono<Signatory> newDeposit = signatoryService.create(c);
        return newDeposit;
    }

    @PutMapping("/update/{id}")
    public Mono<Signatory> updateSignatory(@RequestBody Signatory c, @PathVariable String id){
        log.info("Service call Update - signatory");
        return signatoryService.update(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Signatory> deleteSignatory(@PathVariable String id){
        log.info("Service call Delete - signatory");
                return signatoryService.delete(id);
    }


}
