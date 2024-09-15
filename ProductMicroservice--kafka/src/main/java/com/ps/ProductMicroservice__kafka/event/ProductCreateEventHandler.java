package com.ps.ProductMicroservice__kafka.event;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreateEventHandler {

    Logger LOG= LoggerFactory.getLogger(ProductCreateEventHandler.class);
    @KafkaListener(topics = "product", groupId = "product-group")
    public void handle(ConsumerRecord<String,ProductCreatedEvent> record) {
        LOG.atInfo()
                .addKeyValue("productId", ((ProductCreatedEvent)record.value()).getProductId())
                .addKeyValue("title",((ProductCreatedEvent)record.value()).getTitle())
                .addKeyValue("price",((ProductCreatedEvent)record.value()).getPrice())
                .addKeyValue("qty",((ProductCreatedEvent)record.value()).getQuantity())
                .log();
        LOG.info("Product created event received: " + ((ProductCreatedEvent)record.value()).toString());
    }


    // if we directly want to read the value instead of consumer record
   // @KafkaListener(topics = "product", groupId = "product-group")
   // public void handle(ProductCreatedEvent event) {
    //    LOG.info("Product created event received: " + event.toString());
    //}
}
