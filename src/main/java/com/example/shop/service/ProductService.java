package com.example.shop.service;

import com.example.shop.dto.ProductDto;

import java.util.List;

public interface ProductService <T>{

    T save(T computerDto);

    T update(T computerDto);

    List<T> findAll();

    T findById(Long id);

}
