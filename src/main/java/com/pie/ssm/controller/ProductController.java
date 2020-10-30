package com.pie.ssm.controller;

import com.pie.ssm.entity.Product;
import com.pie.ssm.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;
    @GetMapping("/list")
    public List<Product>list(){
        List<Product>list =null;
        try {
            list= productService.findAll();
        }catch (Exception e){
            System.out.println("系统繁忙");
        }
        return list;
    }
}
