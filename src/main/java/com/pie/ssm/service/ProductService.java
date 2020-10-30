package com.pie.ssm.service;

import com.pie.ssm.entity.Product;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface ProductService {
    List<Product> findAll();
}
