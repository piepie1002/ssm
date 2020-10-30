package com.pie.ssm.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 安全考虑 
 * 对数据进行处理
 * Service层 返回Vo对象
 */
@Data
public class CartsVo implements Serializable {
    private Integer cartsId;
    
    private Integer quantity;
    
    private Integer productId;
    
    private Integer userId;
    
    private Integer status;
    private static final long serialVersionUID = 1L;
    
}

