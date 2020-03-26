package com.travelport.kafka.producer.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.travelport.kafka.client.KafkaProducerConfiguration;
import com.travelport.kafka.client.producer.KafkaProducer;
import com.travelport.kafka.producer.api.message.Greeting;

@RestController
@RequestMapping(value = "/kafka")
@Import(KafkaProducerConfiguration.class) //@Import(Producer.class)
public class KafkaProducerApiController {

    private final KafkaProducer producer;

    @Autowired
    public KafkaProducerApiController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Greeting greeting) throws JsonProcessingException {
        this.producer.sendMessage(greeting);
    }

    //    @PostMapping(value = "/publish")
    //    public void sendMessageToKafkaTopic(@RequestBody Map<String, Object> body) {
    //        String message = (String) body.get("message");
    //        this.producer.sendMessage(message);
    //    }

    @PostMapping(value = "/publish-json")
    public void sendMessageToKafkaTopic(@RequestBody String jsonMessage) {
        String message = StringUtils.trimToEmpty(jsonMessage);
        this.producer.sendMessage(message);
    }
}
