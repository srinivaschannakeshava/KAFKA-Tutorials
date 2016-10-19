package com.srini.main;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import com.srini.clients.KafkaConsumerClient;

public class MainConsumer {
	public static void main(String[] args) {
		KafkaConsumer<String, String> consumer = KafkaConsumerClient.getKafkaConsumer();
		System.out.println(consumer.listTopics());
		String topic = "testKafka";
		TopicPartition partition0 = new TopicPartition(topic, 0);
		consumer.assign(Arrays.asList(partition0));

		// consumer.subscribe(Arrays.asList("testKafka"));

		consumer.seek(partition0, 4000);
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
			}
			consumer.commitSync();
		}

	}
}
