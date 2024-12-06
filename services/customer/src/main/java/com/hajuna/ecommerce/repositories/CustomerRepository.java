package com.hajuna.ecommerce.repositories;

import com.hajuna.ecommerce.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    boolean existsByEmail(String email);
}
