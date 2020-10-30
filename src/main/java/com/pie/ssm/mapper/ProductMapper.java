package com.pie.ssm.mapper;

import com.pie.ssm.entity.Product;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface ProductMapper {
    List<Product> selectProductList();
}
