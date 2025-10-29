package com.pedro.javaRaven.controller;

import com.pedro.javaRaven.dto.ProductRecordDto;
import com.pedro.javaRaven.models.ProductDocument;
import com.pedro.javaRaven.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductControllerRaven {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity<ProductDocument> createProduct(@RequestBody @Valid ProductRecordDto dto){
        var product = new ProductDocument();
        product.setName(dto.name());
        product.setValue(dto.value());

        repository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDocument>> findAll(){
        List<ProductDocument> products = repository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDocument> findById(@PathVariable String id){
        var product = repository.findById(id);
        if(product == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDocument> updateProduct(@PathVariable String id, @RequestBody @Valid ProductRecordDto dto){
        var existing = repository.findById(id);
        if(existing == null) return ResponseEntity.notFound().build();

        existing.setName(dto.name());
        existing.setValue(dto.value());

        return ResponseEntity.ok(existing);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        repository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
