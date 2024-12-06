package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.ImageDTO;
import com.hajuna.ecommerce.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDTO> saveImages(Long productId, List<MultipartFile> files);
    void updateImage(MultipartFile file,  Long imageId);
}
