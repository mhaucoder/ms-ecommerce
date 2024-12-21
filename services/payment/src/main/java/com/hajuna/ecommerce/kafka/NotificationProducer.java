package com.hajuna.ecommerce.kafka;

import com.hajuna.ecommerce.dto.requests.PaymentConfirmationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    private final KafkaTemplate<String, PaymentConfirmationRequestDTO> kafkaTemplate;

    public void sendPaymentConfirmation(PaymentConfirmationRequestDTO paymentNotification) {
        log.info("Sending notification to Kafka : {}", paymentNotification);
        Message<PaymentConfirmationRequestDTO> message = MessageBuilder
                .withPayload(paymentNotification)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
