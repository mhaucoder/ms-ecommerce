package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.requests.PaymentRequestDTO;

public interface IPaymentService {
    Long createPayment(PaymentRequestDTO paymentRequest);
}
