package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByPrice() {
        return productRepository.findAllByOrderByPrice();
    }

    @Override
    public Iterable<Product> find5NewestProduct() {
        return productRepository.find5NewestProduct();
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(int min, int max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

}
