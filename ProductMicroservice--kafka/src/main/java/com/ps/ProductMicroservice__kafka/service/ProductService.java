package com.ps.ProductMicroservice__kafka.service;


import com.ps.ProductMicroservice__kafka.dao.ProductDao;
import com.ps.ProductMicroservice__kafka.event.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    @Value("${spring.kafka.template.topic-name}")
    String topicName;
    public ProductDao createProduct(ProductDao productDao) {
        String productId= UUID.randomUUID().toString();
        ProductCreatedEvent createdEvent= ProductCreatedEvent.builder()
                .productId(productId)
                .price(productDao.getPrice())
                .quantity(productDao.getQuantity())
                .title(productDao.getTitle())
                .build();

        kafkaTemplate.send("product",productId,createdEvent);

        productDao.setProductId(productId);
        return productDao;

    }
}
