package com.hajuna.ecommerce.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CustomerRequestDTO {
    public String id;
    @NotNull(message = "Firstname is required")
    public String firstName;
    @NotNull(message = "Lastname is required")
    public String lastName;
    @NotNull(message = "Email is required")
    public String email;
    public String phone;
}
