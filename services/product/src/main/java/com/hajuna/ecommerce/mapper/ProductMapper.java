package com.hajuna.ecommerce.mapper;

import com.hajuna.ecommerce.dto.ImageDTO;
import com.hajuna.ecommerce.dto.request.UpdateProductRequestDTO;
import com.hajuna.ecommerce.dto.response.ProductResponseDTO;
import com.hajuna.ecommerce.dto.response.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.models.Category;
import com.hajuna.ecommerce.models.Image;
import com.hajuna.ecommerce.models.Product;
import com.hajuna.ecommerce.repositories.CategoryRepository;
import com.hajuna.ecommerce.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper modelMapper;
    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;

    public Product toNewProduct(Product oldProduct, UpdateProductRequestDTO newProduct) {
        oldProduct.setName(newProduct.getName());
        oldProduct.setBrand(newProduct.getBrand());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setInventory(newProduct.getInventory());
        oldProduct.setDescription(newProduct.getDescription());

        Category category = categoryRepository.findByName(newProduct.getCategory().getName());
        oldProduct.setCategory(category);
        return oldProduct;
    }

    public ProductResponseDTO toProductResponseDTO(Product product) {
        ProductResponseDTO productDto = modelMapper.map(product, ProductResponseDTO.class);
        List<Image> images = imageRepository.findByProductId(product.getId());
        List<ImageDTO> imagesDto = images.stream()
                .map(image -> modelMapper.map(image, ImageDTO.class))
                .toList();
        productDto.setImages(imagesDto);
        return productDto;
    }

    public List<ProductResponseDTO> toListProductResponseDTO(List<Product> products) {
        return products.stream().map(this::toProductResponseDTO).toList();
    }

    public PurchaseProductResponseDTO toPurchaseProductResponseDTO(Product product, int quantity) {
        return PurchaseProductResponseDTO.builder()
                .productId(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(quantity)
                .description(product.getDescription())
                .build();
    }

}
