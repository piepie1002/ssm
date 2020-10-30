package com.pie.ssm.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Carts implements Serializable {
    /**
     *
     */
    private Integer cartsId;

    /**
     * 商品的数量
     */
    private Integer quantity;

    /**
     * 商品的外键
     */
    private Integer productId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 0表示正常 1表示删除
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
    
}

