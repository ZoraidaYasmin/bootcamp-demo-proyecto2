package com.proyecto1.purchase.service.impl;

import com.proyecto1.purchase.client.TransactionClient;
import com.proyecto1.purchase.entity.Purchase;
import com.proyecto1.purchase.repository.PurchaseRepository;
import com.proyecto1.purchase.service.PurchaseService;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private static final Logger log = LogManager.getLogger(PurchaseServiceImpl.class);
    @Autowired
    PurchaseRepository purchaseRepository;
    
    @Autowired
    TransactionClient transactionClient;

    @Override
    public Flux<Purchase> findAll() {
        log.info("Method call FindAll - purchase");
        return purchaseRepository.findAll();
    }

    @Override
    public Mono<Purchase> create(Purchase purchase) {
        log.info("Method call create - purchase");
        return Mono.just(purchase).flatMap(p -> {
        	return transactionClient.getTransactionWithDetails(p.getTransactionId())
                    .filter(trans -> trans.getProduct().getTypeProduct() == 6) // Valida si es una tarjeta de credito
                    .flatMap(t -> {
                    	return this.findAllByTransactionId(purchase.getTransactionId()).map(s -> s.getPurchaseAmount())
                    	.reduce(new BigDecimal(0), (x1, x2) -> x1.add(x2))
                    	.flatMap(totalPurchase -> {
                    		if(t.getCreditLimit().compareTo(totalPurchase.add(purchase.getPurchaseAmount())) > -1) {// Valida que el monto disponible sea mayor o igual al monto por comprar
                    			return purchaseRepository.save(purchase);
                    		}else{
                                return Mono.error(new RuntimeException("The purchase could not be made, check your available balance or if the product is a credit card"));
                            }
                    	});
                    });
        });
    }

    @Override
    public Mono<Purchase> findById(String id) {
        log.info("Method call FindById - purchase");
        return purchaseRepository.findById(id);
    }

    @Override
    public Mono<Purchase> update(Purchase c, String id) {
        log.info("Method call Update - purchase");
        return purchaseRepository.findById(id)
                .map( x -> {
                    x.setDate(c.getDate());
                    x.setPurchaseAmount(c.getPurchaseAmount());
                    x.setDescription(c.getDescription());
                    return x;
                }).flatMap(purchaseRepository::save);
    }

    @Override
    public Mono<Purchase> delete(String id) {
        log.info("Method call delete - purchase");
        return purchaseRepository.findById(id).flatMap( x -> purchaseRepository.delete(x).then(Mono.just(new Purchase())));
    }

	@Override
	public Flux<Purchase> findAllByTransactionId(String id) {
		log.info("Method call FindAllByTransactionId - purchase");
        return purchaseRepository.findAll().filter(purch -> purch.getTransactionId().equalsIgnoreCase(id));
	}
}
