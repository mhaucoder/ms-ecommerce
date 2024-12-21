package com.hajuna.ecommerce.services;

import com.hajuna.ecommerce.clients.CustomerClient;
import com.hajuna.ecommerce.clients.PaymentClient;
import com.hajuna.ecommerce.clients.ProductClient;
import com.hajuna.ecommerce.dto.responses.CustomerResponseDTO;
import com.hajuna.ecommerce.utils.constants.ErrorMessages;
import com.hajuna.ecommerce.dto.requests.*;
import com.hajuna.ecommerce.dto.requests.CustomerRequestDTO;
import com.hajuna.ecommerce.dto.responses.OrderResponseDTO;
import com.hajuna.ecommerce.dto.responses.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.exceptions.NotFoundException;
import com.hajuna.ecommerce.kafka.OrderProducer;
import com.hajuna.ecommerce.mappers.OrderMapper;
import com.hajuna.ecommerce.models.Order;
import com.hajuna.ecommerce.repositories.OrderRepository;
import com.hajuna.ecommerce.services.interfaces.IOrderLineService;
import com.hajuna.ecommerce.services.interfaces.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final IOrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Override
    public Long createOrder(OrderRequestDTO request) {
        CustomerResponseDTO customer = customerClient.findCustomerById(request.customerId).orElseThrow(()-> new NotFoundException(ErrorMessages.ORDER_NOT_FOUND));

        List<PurchaseProductResponseDTO> products = productClient.purchaseProduct(request.products);

        Order order = orderRepository.save(orderMapper.toOrder(request));

        for(PurchaseProductRequestDTO purchaseProductRequestDTO : request.products) {
            orderLineService.createOrderLine(
                    new OrderLineRequestDTO(
                            null,
                            order.getId(),
                            purchaseProductRequestDTO.productId,
                            purchaseProductRequestDTO.quantity
                    )
            );
        }

        PaymentRequestDTO payment = new PaymentRequestDTO(
                request.amount,
                request.paymentMethod,
                order.getId(),
                order.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(payment);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmationRequestDTO(
                        request.reference,
                        request.amount,
                        request.paymentMethod,
                        customer,
                        products
                )
        );

        return order.getId();
    }

    @Override
    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Override
    public OrderResponseDTO findById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toOrderResponse)
                .orElseThrow(()-> new NotFoundException(ErrorMessages.ORDER_NOT_FOUND));
    }

}
