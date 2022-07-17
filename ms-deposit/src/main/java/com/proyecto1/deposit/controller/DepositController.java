package com.proyecto1.deposit.controller;

import com.proyecto1.deposit.entity.Deposit;
import com.proyecto1.deposit.service.DepositService;

import com.proyecto1.deposit.service.impl.DepositServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    private static final Logger log = LogManager.getLogger(DepositController.class);
    @Autowired
    private DepositService depositService;

    @GetMapping("/findAll")
    public Flux<Deposit> getDeposits(){
        log.info("Service call findAll - deposit");
        return depositService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Deposit> getDeposit(@PathVariable String id){
        log.info("Service call findById - deposit");
        Mono<Deposit> newDeposit = depositService.findById(id);
        return newDeposit;
    }

    @PostMapping("/create")
    public Mono<Deposit> createDeposit(@RequestBody Deposit c){
        log.info("Service call create - deposit");
        Mono<Deposit> newDeposit = depositService.create(c);
        return newDeposit;
    }

    @PutMapping("/update/{id}")
    public Mono<Deposit> updateDeposit(@RequestBody Deposit c, @PathVariable String id){
        log.info("Service call update - deposit");
        return depositService.update(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Deposit> deleteDeposit(@PathVariable String id){
        log.info("Service call delete - deposit");
                return depositService.delete(id);
    }


}
