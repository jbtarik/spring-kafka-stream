package tr.projects.kafkaconsumer.bindings;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import tr.projects.kafkaconsumer.model.Order;

public interface StreamBindings {
    @Input("order-input-channel")
    KStream<String, Order> inputStream();

    @Output("order-home-output-channel")
    KStream<String, Order> homeDeliveryStream();

    @Output("order-takeaway-output-channel")
    KStream<String, Order> takeAwayStream();
}
