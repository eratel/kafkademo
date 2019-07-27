package com.sunney.main;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


/**
 * @GitHub: https://github.com/eratel
 * @author: jikai.sun
 * @create: 2019/7/25
 **/
public class MyProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        String TOPIC = "test10";
        props.put("bootstrap.servers", "192.168.40.128:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        String msg = "hello word";
        ProducerRecord<String, String> data = new ProducerRecord<>(TOPIC, msg);
        producer.send(data);
        producer.close();
        System.out.println("OK");
    }
}
