package com.Aman.product_service.Controller;

import com.Aman.product_service.Dto.ProductRequest;
import com.Aman.product_service.Dto.ProductResponse;
import com.Aman.product_service.Service.ProductService;
import com.Aman.product_service.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
   private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody ProductRequest productRequest){
        System.out.println("Incoming ProductRequest: " + productRequest);
        System.out.println("Name: " + productRequest.getName());
        System.out.println("Description: " + productRequest.getDescription());
        System.out.println("Price: " + productRequest.getPrice());
        return productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
       return productService.getAllProduct();
    }
}
