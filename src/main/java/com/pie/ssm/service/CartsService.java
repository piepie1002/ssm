package com.pie.ssm.service;

import com.pie.ssm.request.CartsDto;
import com.pie.ssm.vo.ListDataVo;


/**
 * @author LIN
 * @since JDK 1.8
 */
public interface CartsService {
    
    int saveCarts(CartsDto cartsDto);
    
    ListDataVo findAllCarts(int uId);
}
