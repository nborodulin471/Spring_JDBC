package com.borodulin.controller;

import com.borodulin.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
//@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductDao productDao;

    @GetMapping
    public String h (){
        return "hello";
    }

    @GetMapping("products/fetch-product")
    public ResponseEntity<String> fetchProduct(@RequestParam("name") String name) {
        return productDao.getProductName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
