package com.sunney.main;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;


/**
 * @GitHub: https://github.com/eratel
 * @author: jikai.sun
 * @create: 2019/7/25
 **/
public class MyProducer {
    public static void main(String[] args) {
        Map props = new HashMap<>(4);
        String TOPIC = "test";
        props.put("bootstrap.servers", "192.168.40.128:2181");
        props.put("key.serializer", "kafka.serializer.StringEncoder");
        props.put("value.serializer", "kafka.serializer.StringEncoder");
//        props.put("partitioner.class", "com.sunney.main.SimplePartitioner");
        props.put("request.required.acks", "1");

        KafkaProducer<String, String>  producer = new KafkaProducer(props);
        for (long messCount = 0; messCount < 10; messCount++) {
            String msg = "This message is for key - " + messCount;
            ProducerRecord<String, String> data1 = new ProducerRecord<>(TOPIC, String.valueOf(messCount), msg);
            producer.send(data1);
        }
        producer.close();
    }
}
