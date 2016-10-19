package com.srini.clients;

import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaProducerClient {
	public static KafkaProducer<String, String> getProducer() {

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(
				ConfigLoader.getInstance().prodConfigProps);
		return producer;
	}

}
