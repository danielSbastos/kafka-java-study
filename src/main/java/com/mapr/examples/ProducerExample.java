package com.mapr.examples;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;


public class ProducerExample {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 100; i ++) {
            System.out.println(i);
            producer.send(new ProducerRecord<String, String>("daniel", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }
}