package com.ps.ProductMicroservice__kafka.controller;

import com.ps.ProductMicroservice__kafka.dao.ProductDao;
import com.ps.ProductMicroservice__kafka.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

    ProductService productService;
    @PostMapping("/product")
    @ResponseBody
    ResponseEntity<ProductDao> createProduct(@RequestBody ProductDao productDao) {
        ProductDao dao=productService.createProduct(productDao);
        return ResponseEntity.ok(dao);
    }
}
