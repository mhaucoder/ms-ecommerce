package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.response.ProductResponseDTO;
import com.hajuna.ecommerce.dto.request.CreateProductRequestDTO;
import com.hajuna.ecommerce.dto.request.PurchaseProductRequestDTO;
import com.hajuna.ecommerce.dto.request.UpdateProductRequestDTO;
import com.hajuna.ecommerce.dto.response.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.models.Product;

import java.util.List;

public interface IProductService {
    List<PurchaseProductResponseDTO> purchaseProduct(List<PurchaseProductRequestDTO> product);
    ProductResponseDTO addProduct(CreateProductRequestDTO product);
    ProductResponseDTO getProductById(Long id);
    Product findById(Long id);
    void deleteProductById(Long id);
    ProductResponseDTO updateProduct(UpdateProductRequestDTO product, Long productId);
    List<ProductResponseDTO> getAllProducts();
    List<ProductResponseDTO> getProductsByCategory(String category);
    List<ProductResponseDTO> getProductsByBrand(String brand);
    List<ProductResponseDTO> getProductsByCategoryAndBrand(String category, String brand);
    List<ProductResponseDTO> getProductsByName(String name);
    List<ProductResponseDTO> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
