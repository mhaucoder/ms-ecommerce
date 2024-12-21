package com.hajuna.ecommerce.mappers;

import com.hajuna.ecommerce.dto.requests.OrderLineRequestDTO;
import com.hajuna.ecommerce.dto.responses.OrderLineResponseDTO;
import com.hajuna.ecommerce.models.Order;
import com.hajuna.ecommerce.models.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequestDTO orderLineRequestDTO) {
        return OrderLine.builder()
                .id(orderLineRequestDTO.id)
                .productId(orderLineRequestDTO.productId)
                .order(
                        Order.builder()
                                .id(orderLineRequestDTO.orderId)
                                .build()
                )
                .quantity(orderLineRequestDTO.quantity)
                .build();
    }

    public OrderLineResponseDTO toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponseDTO(orderLine.getId(), orderLine.getQuantity()) ;
    }
}
