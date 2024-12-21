package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.requests.OrderRequestDTO;
import com.hajuna.ecommerce.dto.responses.OrderResponseDTO;

import java.util.List;

public interface IOrderService {
    Long createOrder(OrderRequestDTO orderRequestDTO);
    List<OrderResponseDTO> findAll();
    OrderResponseDTO findById(Long id);
}
