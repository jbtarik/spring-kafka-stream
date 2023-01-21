package tr.projects.kafkaproducer.model;

import lombok.Data;

@Data
public class Order {

    private String item;
    private String deliveryType;
    private long quatity;


}
