package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.commons.APIResponse;
import com.hajuna.ecommerce.dtos.requests.OrderLineRequestDTO;
import com.hajuna.ecommerce.dtos.responses.OrderLineResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderLineService {
    Long createOrderLine(OrderLineRequestDTO orderLine);

    List<OrderLineResponseDTO> findByOrderId(Long orderId);
}
