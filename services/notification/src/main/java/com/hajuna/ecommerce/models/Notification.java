package com.hajuna.ecommerce.models;

import com.hajuna.ecommerce.dto.requests.OrderConfirmationRequestDTO;
import com.hajuna.ecommerce.dto.requests.PaymentConfirmationRequestDTO;
import com.hajuna.ecommerce.utils.enums.NotificationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmationRequestDTO orderConfirmation;
    private PaymentConfirmationRequestDTO paymentConfirmation;
}
