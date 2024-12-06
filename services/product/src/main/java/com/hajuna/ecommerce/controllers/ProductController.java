package com.hajuna.ecommerce.controllers;


import com.hajuna.ecommerce.commons.APIResponse;
import com.hajuna.ecommerce.dto.response.ProductResponseDTO;
import com.hajuna.ecommerce.dto.request.CreateProductRequestDTO;
import com.hajuna.ecommerce.dto.request.PurchaseProductRequestDTO;
import com.hajuna.ecommerce.dto.request.UpdateProductRequestDTO;
import com.hajuna.ecommerce.dto.response.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.services.interfaces.IProductService;
import com.hajuna.ecommerce.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseUtils.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<APIResponse> getProductById(@PathVariable Long productId) {
        ProductResponseDTO product = productService.getProductById(productId);
        return ResponseUtils.ok(product);
    }

    @PostMapping("/purchase")
    public ResponseEntity<APIResponse> purchaseProduct(@RequestBody List<PurchaseProductRequestDTO> purchaseProductRequest) {
        List<PurchaseProductResponseDTO> products = productService.purchaseProduct(purchaseProductRequest);
        return ResponseUtils.ok(products);
    }

    @PostMapping()
    public ResponseEntity<APIResponse> addProduct(@RequestBody CreateProductRequestDTO createProductRequest) {
        ProductResponseDTO product = productService.addProduct(createProductRequest);
        return ResponseUtils.ok(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<APIResponse> updateProduct(@RequestBody UpdateProductRequestDTO request, @PathVariable Long productId) {
        ProductResponseDTO product = productService.updateProduct(request, productId);
        return ResponseUtils.ok(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<APIResponse> deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return ResponseUtils.ok(productId);
    }

    @GetMapping("/by/brand-and-name")
    public ResponseEntity<APIResponse> getProductByBrandAndName(@RequestParam String brandName, @RequestParam String productName) {
        List<ProductResponseDTO> products = productService.getProductsByBrandAndName(brandName, productName);
        return ResponseUtils.ok(products);
    }

    @GetMapping("/by/category-and-brand")
    public ResponseEntity<APIResponse> getProductByCategoryAndBrand(@RequestParam String category, @RequestParam String brand) {
        List<ProductResponseDTO> products = productService.getProductsByCategoryAndBrand(category, brand);
        return ResponseUtils.ok(products);
    }

    @GetMapping("/by/{name}")
    public ResponseEntity<APIResponse> getProductByName(@PathVariable String name) {
        List<ProductResponseDTO> products = productService.getProductsByName(name);
        return ResponseUtils.ok(products);
    }

    @GetMapping("/by/{brand}")
    public ResponseEntity<APIResponse> findProductByBrand(@PathVariable String brand) {
        List<ProductResponseDTO> products = productService.getProductsByBrand(brand);
        return ResponseUtils.ok(products);
    }

    @GetMapping("/by/{category}")
    public ResponseEntity<APIResponse> findProductByCategory(@PathVariable String category) {
        List<ProductResponseDTO> products = productService.getProductsByCategory(category);
        return ResponseUtils.ok(products);
    }
    @GetMapping("/count/by-brand-and-name")
    public ResponseEntity<APIResponse> countProductsByBrandAndName(@RequestParam String brand, @RequestParam String name) {
        var productCount = productService.countProductsByBrandAndName(brand, name);
        return ResponseUtils.ok(productCount);
    }
    
}
