package com.pie.ssm.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProductCategory implements Serializable {
    /**
     * 产品属性分类id
     */
    private Long productCategoryId;

    /**
     * 产品属性名称
     */
    private String productCategoryName;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌分类id
     */
    private Long categoryId;

    /**
     * 状态值
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

