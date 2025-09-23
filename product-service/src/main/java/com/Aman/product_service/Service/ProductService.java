package com.Aman.product_service.Service;
import com.Aman.product_service.Dto.ProductRequest;
import com.Aman.product_service.Dto.ProductResponse;
import com.Aman.product_service.Repository.ProductRepository;
import com.Aman.product_service.model.Product;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequest productRequest){

        Product product= new Product();
                product.setName(productRequest.getName());
                product.setDescription(productRequest.getDescription());
                product.setPrice(productRequest.getPrice());
        return productRepository.save(product);
    }

    public List<ProductResponse> getAllProduct() {
        List<Product>products=productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );

    }
}
