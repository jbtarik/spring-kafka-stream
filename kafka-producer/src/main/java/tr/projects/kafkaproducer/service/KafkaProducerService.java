package tr.projects.kafkaproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tr.projects.kafkaproducer.model.Order;

import java.util.UUID;

@Service
public class KafkaProducerService {
    private final static Logger LOGGER= LoggerFactory.getLogger(KafkaProducerService.class);
    private final static String TOPIC="user";
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void send(Order order){
        LOGGER.info("Order object is {}",order);
        kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(),order);
    }
}
