package com.hajuna.ecommerce.repositories;

import com.hajuna.ecommerce.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findByOrderId(Long orderId);
}
