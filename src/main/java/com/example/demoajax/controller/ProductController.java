package com.example.demoajax.controller;

import com.example.demoajax.query.Demo;
import com.example.demoajax.model.Product;
import com.example.demoajax.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Cho phép các cổng truy cập để kết nối với ajax
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> products() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countProduct() {
        return new ResponseEntity<>(productService.countProduct(), HttpStatus.OK);
    }

    @GetMapping("/demo")
    public ResponseEntity<List<Demo>> demo() {
        return new ResponseEntity<>(productService.getDemo(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    // Delete (DeleteMapping)
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    // Edit (PutMapping)
    @PutMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
