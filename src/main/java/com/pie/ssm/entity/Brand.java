package com.pie.ssm.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Brand implements Serializable {
    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 状态值
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
    
}

