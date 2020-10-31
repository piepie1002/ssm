package com.pie.ssm.request;

import lombok.Data;

/**
 * @author LIN
 * @since JDK 1.8
 * 
 *   购物车参数类
 */
@Data
public class CartsDto {
    private Integer userId;
    private Integer quantity;
    private Integer productId;
    
}
