package org.Aman;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NortificationServiceApplication {


    private static final Logger log = LoggerFactory.getLogger(NortificationServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(NortificationServiceApplication.class,args);
    }
    @KafkaListener(topics = "nortificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        log.info("Received Notification for order: {}", orderPlacedEvent.getOrderNumber());
    }
}