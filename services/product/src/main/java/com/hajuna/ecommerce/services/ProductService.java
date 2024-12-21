package com.hajuna.ecommerce.services;

import com.hajuna.ecommerce.utils.constants.ErrorMessages;
import com.hajuna.ecommerce.dto.response.ProductResponseDTO;
import com.hajuna.ecommerce.dto.request.CreateProductRequestDTO;
import com.hajuna.ecommerce.dto.request.PurchaseProductRequestDTO;
import com.hajuna.ecommerce.dto.request.UpdateProductRequestDTO;
import com.hajuna.ecommerce.dto.response.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.exceptions.InvalidValueException;
import com.hajuna.ecommerce.exceptions.NotFoundException;
import com.hajuna.ecommerce.mapper.ProductMapper;
import com.hajuna.ecommerce.models.Category;
import com.hajuna.ecommerce.models.Product;
import com.hajuna.ecommerce.repositories.CategoryRepository;
import com.hajuna.ecommerce.repositories.ProductRepository;
import com.hajuna.ecommerce.services.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public List<PurchaseProductResponseDTO> purchaseProduct(List<PurchaseProductRequestDTO> products) {
        List<Long> productIds = products.stream().map(PurchaseProductRequestDTO::getProductId).toList();
        List<Product> productList = productRepository.findAllByIdInOrderById(productIds).stream().sorted(Comparator.comparing(Product::getId)).toList();
        if(productList.size() != productIds.size()) {
            throw new NotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);
        }
        List<PurchaseProductRequestDTO> requestProducts = products.stream().sorted(Comparator.comparing(PurchaseProductRequestDTO::getProductId)).toList();
        List<PurchaseProductResponseDTO> purchaseProducts = new ArrayList<>();
        for(int i = 0; i<requestProducts.size(); i++) {
            Product product = productList.get(i);
            PurchaseProductRequestDTO requestProduct = requestProducts.get(i);
            if(requestProduct.getQuantity() > product.getInventory()){
                 throw new InvalidValueException(ErrorMessages.PRODUCT_VALUE_NOT_VALID);
            }
            int newInventory = product.getInventory() - requestProduct.getQuantity();
            product.setInventory(newInventory);
            productRepository.save(product);
            purchaseProducts.add(productMapper.toPurchaseProductResponseDTO(product, newInventory));
        }
        return purchaseProducts;
    }

    @Override
    public ProductResponseDTO addProduct(CreateProductRequestDTO request) {
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        request.setCategory(category);
        Product newProduct = new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
        return productMapper.toProductResponseDTO(productRepository.save(newProduct));
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public ProductResponseDTO getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toProductResponseDTO)
                .orElseThrow(()-> new NotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete,
                        () -> {throw new NotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);});
    }

    @Override
    public ProductResponseDTO updateProduct(UpdateProductRequestDTO request, Long productId) {
        return productRepository.findById(productId)
                .map(existingProduct -> productMapper.toNewProduct(existingProduct,request))
                .map(productRepository :: save)
                .map(productMapper::toProductResponseDTO)
                .orElseThrow(()-> new NotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category).stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand).stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand).stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getProductsByName(String name) {
        return productRepository.findByName(name).stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name).stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }

}
