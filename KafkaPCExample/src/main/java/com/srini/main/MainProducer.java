package com.srini.main;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.srini.clients.ConfigLoader;
import com.srini.clients.KafkaProducerClient;

public class MainProducer {
	public static void main(String[] args) {
		KafkaProducer<String, String> producer = KafkaProducerClient.getProducer();
		for (int i = 0; i < 1000; i++) {
			producer.send(getProducerRecord("testKafka", "hello" + i, "kafka" + i), new Callback() {

				@Override
				public void onCompletion(RecordMetadata metadata, Exception e) {
					// TODO Auto-generated method stub
					if (e != null) {
						e.printStackTrace();
						System.out.println("The offset of the record we just sent is: " + metadata.offset());
					}
					System.out.println("Message sent successfully");
				}
			});

		}
		producer.close();

	}

	public static ProducerRecord<String, String> getProducerRecord(String topic, String key, String value) {
		return new ProducerRecord<String, String>(topic, key, value);
	}

}
