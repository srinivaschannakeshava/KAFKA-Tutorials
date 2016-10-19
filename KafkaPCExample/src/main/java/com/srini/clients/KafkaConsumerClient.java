package com.srini.clients;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerClient {
	public static KafkaConsumer<String, String> getKafkaConsumer() {
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(ConfigLoader.getInstance().consConfigProps);
		return consumer;
	}
}
