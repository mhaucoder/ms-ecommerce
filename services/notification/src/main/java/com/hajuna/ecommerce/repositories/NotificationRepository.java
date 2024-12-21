package com.hajuna.ecommerce.repositories;

import com.hajuna.ecommerce.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
}
