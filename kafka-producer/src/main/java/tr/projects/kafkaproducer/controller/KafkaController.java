package tr.projects.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.projects.kafkaproducer.model.Order;
import tr.projects.kafkaproducer.service.KafkaProducerService;

@RestController
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/post")
    public void order(@RequestBody Order order){
        kafkaProducerService.send(order);
    }
}
