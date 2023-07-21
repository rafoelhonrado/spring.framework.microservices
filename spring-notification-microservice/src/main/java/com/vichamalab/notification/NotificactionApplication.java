package com.vichamalab.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.vichamalab.notification.model.OrderPlacedEvent;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class NotificactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificactionApplication.class, args);
	}
	
	@KafkaListener(topics="notificationTopic")
	public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
		log.info("Received notification for order - {}", orderPlacedEvent.getOrderNumber());
	}
}
