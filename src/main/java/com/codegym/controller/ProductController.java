package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        List<Product> productList = (List<Product>) productService.findAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Iterable<Product>> findAllProduct(@PathVariable String name) {
        List<Product> productList = (List<Product>) productService.findAllByNameContaining(name);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/sort_by_price")
    public ResponseEntity<Iterable<Product>> findAllProductByPrice() {
        List<Product> productList = (List<Product>) productService.findAllByOrderByPrice();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/5_newest_products")
    public ResponseEntity<Iterable<Product>> find5NewestProduct() {
        List<Product> productList = (List<Product>) productService.find5NewestProduct();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/find_product_by_price_range")
    public ResponseEntity<Iterable<Product>> findProductByPriceRange(@RequestParam int min, int max) {
        List<Product> productList = (List<Product>) productService.findAllByPriceBetween(min, max);

        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
