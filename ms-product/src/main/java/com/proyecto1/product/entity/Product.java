package com.proyecto1.product.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schema_prod.product")
@Data
public class Product {
    @Id
    private String id;

    private int indProduct;
    private String descIndProduct;
    private int typeProduct;
    private String descTypeProduct;
}
