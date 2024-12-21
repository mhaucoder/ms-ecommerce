package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.requests.OrderLineRequestDTO;
import com.hajuna.ecommerce.dto.responses.OrderLineResponseDTO;

import java.util.List;

public interface IOrderLineService {
    void createOrderLine(OrderLineRequestDTO orderLine);
    List<OrderLineResponseDTO> findByOrderId(Long orderId);
}
