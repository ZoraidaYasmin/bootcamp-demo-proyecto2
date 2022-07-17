package com.proyecto1.payment.controller;

import com.proyecto1.payment.entity.Payment;
import com.proyecto1.payment.service.PaymentService;

import com.proyecto1.payment.service.impl.PaymentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger log = LogManager.getLogger(PaymentController.class);
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/findAll")
    public Flux<Payment> getPayments(){
        log.info("Service call FindAll - payment");
        return paymentService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Payment> getPayment(@PathVariable String id){
        log.info("Service call FindById - payment");
        Mono<Payment> newDeposit = paymentService.findById(id);
        return newDeposit;
    }

    @PostMapping("/create")
    public Mono<Payment> createPayment(@RequestBody Payment c){
        log.info("Service call create - payment");
        Mono<Payment> newDeposit = paymentService.create(c);
        return newDeposit;
    }

    @PutMapping("/update/{id}")
    public Mono<Payment> updatePayment(@RequestBody Payment c, @PathVariable String id){
        log.info("Service call update - payment");
        return paymentService.update(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Payment> deletePayment(@PathVariable String id){
        log.info("Service call delete - payment");
                return paymentService.delete(id);
    }


}
