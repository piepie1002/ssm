package com.pie.ssm.service.impl;

import com.pie.ssm.entity.Product;
import com.pie.ssm.mapper.ProductMapper;
import com.pie.ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        List<Product> list = productMapper.selectProductList();
        return list;
    }
}
