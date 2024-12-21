package com.hajuna.ecommerce.clients;

import com.hajuna.ecommerce.dto.requests.PurchaseProductRequestDTO;
import com.hajuna.ecommerce.dto.responses.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.exceptions.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;
    public List<PurchaseProductResponseDTO> purchaseProduct(List<PurchaseProductRequestDTO> productRequest) {
         HttpHeaders headers = new HttpHeaders();
         headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);

         HttpEntity<List<PurchaseProductRequestDTO>> requestEntity = new HttpEntity<>(productRequest, headers);
         ParameterizedTypeReference<List<PurchaseProductResponseDTO>> responseType = new ParameterizedTypeReference<>() {};
         ResponseEntity<List<PurchaseProductResponseDTO>> responseEntity = restTemplate.exchange(
                productUrl+"/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
         );

         if(responseEntity.getStatusCode().isError()) {
            throw new ClientException("Product is error");
         }

         return responseEntity.getBody();
    };
}
