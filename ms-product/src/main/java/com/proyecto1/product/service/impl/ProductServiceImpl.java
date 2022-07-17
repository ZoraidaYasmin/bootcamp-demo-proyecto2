package com.proyecto1.product.service.impl;

import com.proyecto1.product.entity.Product;
import com.proyecto1.product.repository.ProductRepository;
import com.proyecto1.product.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LogManager.getLogger(ProductServiceImpl.class);
    @Autowired
    ProductRepository productRepository;

    @Override
    public Flux<Product> findAll() {
        log.info("Method call FindAll - product");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> create(Product c) {
        log.info("Method call Create - product");
        return productRepository.save(c);
    }

    @Override
    public Mono<Product> findById(String id) {
        log.info("Method call findById - product");
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> update(Product c, String id) {
        log.info("Method call update - product");
        return productRepository.findById(id)
                .map( x -> {
                    x.setIndProduct(c.getIndProduct());
                    x.setDescIndProduct(c.getDescIndProduct());
                    x.setTypeProduct(c.getTypeProduct());
                    x.setDescTypeProduct(c.getDescTypeProduct());
                    return x;
                }).flatMap(productRepository::save);
    }

    @Override
    public Mono<Product> delete(String id) {
        log.info("Method call delete - product");
        return productRepository.findById(id).flatMap(
                x -> productRepository.delete(x).then(Mono.just(new Product())));
    }
}
