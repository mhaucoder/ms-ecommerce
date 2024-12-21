package com.hajuna.ecommerce.kafka;

import com.hajuna.ecommerce.dto.requests.OrderConfirmationRequestDTO;
import com.hajuna.ecommerce.dto.requests.PaymentConfirmationRequestDTO;
import com.hajuna.ecommerce.models.Notification;
import com.hajuna.ecommerce.repositories.NotificationRepository;
import com.hajuna.ecommerce.services.interfaces.IEmailService;
import com.hajuna.ecommerce.utils.enums.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;
    private final IEmailService emailService;

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmationRequestDTO orderConfirmationRequestDTO) throws MessagingException {
        log.info("Consuming the message from order-topic: {}", orderConfirmationRequestDTO);
        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmationRequestDTO)
                        .build()
        );
        String customerName = orderConfirmationRequestDTO.getCustomer().firstName+ " " + orderConfirmationRequestDTO.getCustomer().lastName;
        emailService.sendOrderConfirmationEmail(
                orderConfirmationRequestDTO.getCustomer().email,
                customerName,
                orderConfirmationRequestDTO.getTotalAmount(),
                orderConfirmationRequestDTO.orderReference,
                orderConfirmationRequestDTO.getProducts()
        );
    }

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmationNotification(PaymentConfirmationRequestDTO paymentConfirmationRequestDTO) throws MessagingException {
        log.info("Consuming the message from payment-topic: {}", paymentConfirmationRequestDTO);
        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmationRequestDTO)
                        .build()
        );
        String customerName = paymentConfirmationRequestDTO.customerFirstName+ " " + paymentConfirmationRequestDTO.customerLastName;
        emailService.sendPaymentConfirmationEmail(
                paymentConfirmationRequestDTO.customerEmail,
                customerName,
                paymentConfirmationRequestDTO.amount,
                paymentConfirmationRequestDTO.orderReference
        );
    }
}
