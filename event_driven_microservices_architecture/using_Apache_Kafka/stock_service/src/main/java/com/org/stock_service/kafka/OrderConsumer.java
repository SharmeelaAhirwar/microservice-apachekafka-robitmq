package com.org.stock_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.org.base_domain.dto.OrderEvent;

@Service
public class OrderConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("order event reieved in stock service =>%s", event.toString()));
		
		//save the order event into database
	}
	

}
