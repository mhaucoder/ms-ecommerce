package com.hajuna.ecommerce.repositories;

import com.hajuna.ecommerce.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
