package com.hajuna.ecommerce.services;

import com.hajuna.ecommerce.dto.requests.PaymentConfirmationRequestDTO;
import com.hajuna.ecommerce.dto.requests.PaymentRequestDTO;
import com.hajuna.ecommerce.kafka.NotificationProducer;
import com.hajuna.ecommerce.mappers.PaymentMapper;
import com.hajuna.ecommerce.models.Payment;
import com.hajuna.ecommerce.repositories.PaymentRepository;
import com.hajuna.ecommerce.services.interfaces.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;
    @Override
    public Long createPayment(PaymentRequestDTO paymentRequest) {
        System.out.println(paymentRequest);
        Payment payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        notificationProducer.sendPaymentConfirmation(
                new PaymentConfirmationRequestDTO(
                        paymentRequest.orderReference,
                        paymentRequest.amount,
                        paymentRequest.paymentMethod,
                        paymentRequest.customer.firstName,
                        paymentRequest.customer.lastName,
                        paymentRequest.customer.email,
                        paymentRequest.customer.phone
                )
        );
        return payment.getId();
    }
}
