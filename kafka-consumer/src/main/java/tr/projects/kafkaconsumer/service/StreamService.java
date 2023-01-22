package tr.projects.kafkaconsumer.service;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import tr.projects.kafkaconsumer.bindings.StreamBindings;
import tr.projects.kafkaconsumer.model.Order;

@Service
@EnableBinding(StreamBindings.class)
public class StreamService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StreamService.class);

    @StreamListener("order-input-channel")
    @SendTo({"order-home-output-channel", "order-takeaway-output-channel"})
    public KStream<Object, Order>[] process(KStream<String, Order> input) {

        Predicate<Object, Order> homePredicate = (k, v) -> v.getDeliveryType().equals("home");
        Predicate<Object, Order> awayPredicate = (k, v) -> v.getDeliveryType().equals("away");

        return input
                .map((key, value) -> new KeyValue<>(null, value))
                .branch(homePredicate, awayPredicate);
    }

}
