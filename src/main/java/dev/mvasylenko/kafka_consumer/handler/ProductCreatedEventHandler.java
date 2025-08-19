package dev.mvasylenko.kafka_consumer.handler;

import dev.mvasylenko.kafka_util.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = {"product-created-events-topic", "other-events-topic"})
public class ProductCreatedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductCreatedEventHandler.class);

    @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent) {
        LOGGER.info("Received a new event: {}", productCreatedEvent.getTitle());
    }
}
