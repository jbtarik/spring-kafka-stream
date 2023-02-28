# Getting Started

### STEPS TO TEST PROJECT

## to run kafka brocker 
    >docker-compose up

## run kafka producer app KafkaProducerApplication

## run kafka consumer app KafkaConsumerApplication

## go to postman and make post request 

# url : http://localhost:8080/post

##### body objects 
## send to away topic 
## { "item":"fried chicken","deliveryType":"away","quatity":50}
##  { "item":"sandwich","deliveryType":"away","quatity":5}

## send to home topic
##  { "item":"fried chicken","deliveryType":"home","quatity":15}
##  { "item":"pizza","deliveryType":"home","quatity":3}


## read messages

## go to terminal

# user topic as input for kafka-stream
> sudo docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092   --topic user  --from-beginning

# emporter-service topic to filter message delivery type 'away'
> sudo docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092   --topic emporter-service --from-beginning

# home-service topic to filter message with delivery type 'home'
> sudo docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092   --topic domicile-service --from-beginning



