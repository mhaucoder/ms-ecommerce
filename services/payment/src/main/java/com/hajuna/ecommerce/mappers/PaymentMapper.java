package com.hajuna.ecommerce.mappers;

import com.hajuna.ecommerce.dto.requests.PaymentRequestDTO;
import com.hajuna.ecommerce.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequestDTO paymentRequestDTO) {
        return Payment.builder()
                .id(paymentRequestDTO.id)
                .amount(paymentRequestDTO.amount)
                .paymentMethod(paymentRequestDTO.paymentMethod)
                .orderId(paymentRequestDTO.orderId)
                .build();
    }
}
