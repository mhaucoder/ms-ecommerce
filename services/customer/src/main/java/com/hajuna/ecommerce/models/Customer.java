package com.hajuna.ecommerce.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Document
public class Customer {
    @Id
    private String id;
    private String fistName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
