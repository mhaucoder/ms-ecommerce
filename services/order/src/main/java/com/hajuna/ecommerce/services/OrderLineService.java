package com.hajuna.ecommerce.services;

import com.hajuna.ecommerce.dto.requests.OrderLineRequestDTO;
import com.hajuna.ecommerce.dto.responses.OrderLineResponseDTO;
import com.hajuna.ecommerce.mappers.OrderLineMapper;
import com.hajuna.ecommerce.models.OrderLine;
import com.hajuna.ecommerce.repositories.OrderLineRepository;
import com.hajuna.ecommerce.services.interfaces.IOrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService implements IOrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public void createOrderLine(OrderLineRequestDTO orderLineRequestDTO) {
             OrderLine orderLine = orderLineMapper.toOrderLine(orderLineRequestDTO);
        orderLineRepository.save(orderLine);
    }

    @Override
    public List<OrderLineResponseDTO> findByOrderId(Long orderId) {
        return orderLineRepository.findByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .toList();
    }
}
