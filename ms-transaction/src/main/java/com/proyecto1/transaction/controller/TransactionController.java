package com.proyecto1.transaction.controller;

import com.proyecto1.transaction.entity.Transaction;
import com.proyecto1.transaction.service.TransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private static final Logger log = LogManager.getLogger(TransactionController.class);
    @Autowired
    TransactionService transactionService;

    @GetMapping("/findAll")
    public Flux<Transaction> getTransaction(){
        log.info("Service call FindAll - transaction");
        return transactionService.findAll();
    }
    
    @GetMapping("/findAllWithDetail")
    public Flux<Transaction> getTransactions(){
        log.info("Service call findAllWithDetail - transaction");
        return transactionService.findAllWithDetail();
    }

    @GetMapping("/find/{id}")
    public Mono<Transaction> getTransaction(@PathVariable String id){
        log.info("Service call FindById - transaction");
        Mono<Transaction> newTransaction = transactionService.findById(id);
        return newTransaction;
    }
    @GetMapping("/findByIdWithCustomer/{id}")
    public Mono<Transaction> getTransactionWithCustomer(@PathVariable String id){
        log.info("Service call findWithCustomer - transaction");
        Mono<Transaction> newTransaction = transactionService.findByIdWithCustomer(id);
        return newTransaction;
    }
    @PostMapping("/create")
    public Mono<Transaction> createTransaction(@RequestBody Transaction t){
        log.info("Service call Create - transaction");
        Mono<Transaction> newTransaction = transactionService.save(t);
        return newTransaction;
    }

    @PutMapping("/update/{id}")
    public Mono<Transaction> updateTransaction(@RequestBody Transaction t, @PathVariable String id){
        log.info("Service call Update - transaction");
        return transactionService.update(t,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Transaction> deleteTransaction(@PathVariable String id){
        log.info("Service call Delete - transaction");
        return transactionService.delete(id);
    }
}
