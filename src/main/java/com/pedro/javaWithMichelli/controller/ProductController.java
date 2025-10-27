package com.pedro.javaWithMichelli.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.pedro.javaWithMichelli.dto.ProductRecordDto;
import com.pedro.javaWithMichelli.models.ProductModel;
import com.pedro.javaWithMichelli.repositories.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> createProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

}
