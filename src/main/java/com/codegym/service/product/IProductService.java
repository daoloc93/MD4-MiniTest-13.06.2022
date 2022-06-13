package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {

    Iterable<Product> findAllByNameContaining(String name);

    Iterable<Product> findAllByOrderByPrice();

    Iterable<Product> find5NewestProduct();

    Iterable<Product> findAllByPriceBetween(int min, int max);
}

