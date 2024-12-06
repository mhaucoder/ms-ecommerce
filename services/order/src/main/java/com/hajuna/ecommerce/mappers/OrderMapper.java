package com.hajuna.ecommerce.mappers;

import com.hajuna.ecommerce.dtos.requests.OrderRequestDTO;
import com.hajuna.ecommerce.dtos.responses.OrderResponseDTO;
import com.hajuna.ecommerce.models.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequestDTO orderRequestDTO){
       return Order.builder()
               .id(orderRequestDTO.id)
               .customerId(orderRequestDTO.customerId)
               .reference(orderRequestDTO.reference)
               .totalAmount(orderRequestDTO.amount)
               .paymentMethod(orderRequestDTO.paymentMethod)
               .build();
    }

    public OrderResponseDTO toOrderResponse(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
