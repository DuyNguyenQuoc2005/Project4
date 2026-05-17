package com.dtkt.prj4.controller;

import com.dtkt.prj4.dto.DTKTProductRequestDTO;
import com.dtkt.prj4.entity.Product;
import com.dtkt.prj4.service.DTKTProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dtkt/products")
public class DTKTProductController {

    private final DTKTProductService productService;

    public DTKTProductController(
            DTKTProductService productService
    ) {
        this.productService = productService;
    }

    // GET ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id
    ) {
        return productService.getProductById(id);
    }

    // CREATE
    @PostMapping
    public Product createProduct(
            @RequestBody DTKTProductRequestDTO request
    ) {
        return productService.createProduct(request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id
    ) {
        return productService.deleteProduct(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody DTKTProductRequestDTO request
    ) {
        return productService.updateProduct(id, request);
    }
}