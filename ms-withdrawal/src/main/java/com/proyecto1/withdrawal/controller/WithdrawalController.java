package com.proyecto1.withdrawal.controller;

import com.proyecto1.withdrawal.entity.Withdrawal;
import com.proyecto1.withdrawal.service.WithdrawalService;

import com.proyecto1.withdrawal.service.impl.WithdrawalServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {
    private static final Logger log = LogManager.getLogger(WithdrawalController.class);
    @Autowired
    private WithdrawalService withdrawalService;

    @GetMapping("/findAll")
    public Flux<Withdrawal> getWithdrawals(){
        log.info("Service call FindAll - withdrawal");
        return withdrawalService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Withdrawal> getWithdrawal(@PathVariable String id){
        log.info("Service call FindById - withdrawal");
        Mono<Withdrawal> newDeposit = withdrawalService.findById(id);
        return newDeposit;
    }

    @PostMapping("/create")
    public Mono<Withdrawal> createWithdrawal(@RequestBody Withdrawal c){
        log.info("Service call Create - withdrawal");
        Mono<Withdrawal> newDeposit = withdrawalService.create(c);
        return newDeposit;
    }

    @PutMapping("/update/{id}")
    public Mono<Withdrawal> updateWithdrawal(@RequestBody Withdrawal c, @PathVariable String id){
        log.info("Service call Update - withdrawal");
        return withdrawalService.update(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Withdrawal> deleteWithdrawal(@PathVariable String id){
        log.info("Service call Delete - withdrawal");
                return withdrawalService.delete(id);
    }


}
