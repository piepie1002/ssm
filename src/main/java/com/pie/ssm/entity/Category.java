package com.pie.ssm.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class Category implements Serializable {
    /**
     * 品牌分类id
     */
    private Long categoryId;

    /**
     * 品牌分类名称
     */
    private String categoryName;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 状态值
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

