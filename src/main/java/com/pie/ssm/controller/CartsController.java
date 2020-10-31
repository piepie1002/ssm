package com.pie.ssm.controller;

import com.pie.ssm.request.CartsDto;
import com.pie.ssm.respone.ResponseEntity;
import com.pie.ssm.service.CartsService;
import com.pie.ssm.vo.ListDataVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author LIN
 * @since JDK 1.8
 */
/* 购物车
* 1.添加购物车
* 2.查看购物车
* 3.删除购物车
* 4.修改商品数量
* */
@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    CartsService cartsService;
    /**
     * 通过用户id查询购物车信息
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<ListDataVo> list(@RequestParam("userId") int userId){
        try {
            ListDataVo listDataVo = cartsService.findAllCarts(userId);
            return ResponseEntity.success(listDataVo);
        }catch (Exception e){
            return ResponseEntity.error();    
        }
        
    }

    /**
     *  添加购物车
     * @param cartsDto
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Object> add(CartsDto cartsDto){
        boolean flag =false;
        try {
            int i = cartsService.saveCarts(cartsDto);
            if (i>0){
                return ResponseEntity.success(true);
            }else {
                return ResponseEntity.error();
            }
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }

    /**
     *  删除购物车
     * @param cartsDto
     * @return
     */
    @PutMapping("/del")
    public ResponseEntity<ListDataVo> del(CartsDto cartsDto){
        try {
            ListDataVo listDataVo = cartsService.deleteCarts(cartsDto);
            return ResponseEntity.success(listDataVo);
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }
    @PutMapping("/update")
    public ResponseEntity<ListDataVo> updateQuantity(CartsDto cartsDto){
        try {
            ListDataVo listDataVo = cartsService.updateQuantity(cartsDto);
            return ResponseEntity.success(listDataVo);
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }
}
