package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByOrderByPrice();
    @Query(value = "select * from products order by id limit 5;", nativeQuery = true)
    Iterable<Product> find5NewestProduct();
    Iterable<Product> findAllByPriceBetween(int min, int max);
}
