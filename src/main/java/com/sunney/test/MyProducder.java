package com.sunney.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.HashMap;
import java.util.Map;


public class MyProducder {

    public MyProducder() {
        Map properties = new HashMap<String,String>();
        properties.put("brok.list", "localhost:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("request,reqired.acks", "1");
        Producer<Integer, String> producer = new KafkaProducer(properties);

        ProducerRecord<Integer, String> msg = new ProducerRecord<>("test", 100, "hello word");
        producer.send(msg);
        System.out.println("ok");

    }
}
