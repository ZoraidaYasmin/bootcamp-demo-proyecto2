package com.proyecto1.purchase.controller;

import com.proyecto1.purchase.entity.Purchase;
import com.proyecto1.purchase.service.PurchaseService;

import com.proyecto1.purchase.service.impl.PurchaseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private static final Logger log = LogManager.getLogger(PurchaseController.class);
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/findAll")
    public Flux<Purchase> getPurchases(){
        log.info("Service call FindAll - purchase");
        return purchaseService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Purchase> getPurchase(@PathVariable String id){
        log.info("Service call FindById - purchase");
        Mono<Purchase> newDeposit = purchaseService.findById(id);
        return newDeposit;
    }

    @PostMapping("/create")
    public Mono<Purchase> createPurchase(@RequestBody Purchase c){
        log.info("Service call Create - purchase");
        Mono<Purchase> newDeposit = purchaseService.create(c);
        return newDeposit;
    }

    @PutMapping("/update/{id}")
    public Mono<Purchase> updatePurchase(@RequestBody Purchase c, @PathVariable String id){
        log.info("Service call Update - purchase");
        return purchaseService.update(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Purchase> deletePurchase(@PathVariable String id){
        log.info("Service call delete - purchase");
                return purchaseService.delete(id);
    }


}
