package com.sunney.main;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @GitHub: https://github.com/eratel
 * @author: jikai.sun
 * @create: 2019/7/25
 **/
public class MyConsumers {
    public static void main(String[] args) {
        Properties props = new Properties();
        String TOPIC = "test10";
        String GROUP = "g1";

        props.put("bootstrap.servers", "192.168.40.128:9092");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //消费者组的名称
        props.put("group.id", GROUP);
        //从头开始消费
        props.put("auto.offset.reset", "earliest");

        KafkaConsumer consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList(TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord record : records) {
                System.out.println(record.value());
            }
        }
    }
}

