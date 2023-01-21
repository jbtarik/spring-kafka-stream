package tr.projects.kafkaconsumer.model;

import lombok.Data;

@Data
public class Order {
    private String item;
    private String deliveryType;
    private long quatity;
}
