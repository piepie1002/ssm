package com.pie.ssm.mapper;

import com.pie.ssm.entity.Carts;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author LIN
 * @since JDK 1.8
 */
public interface CartsMapper {
    /**
     * 添加购物车
     * @param carts
     * @return
     */
    int insert(@Param("carts") Carts carts);

    /**
     * 查询购物车
     * @param userId
     * @param productId
     * @return
     */
    Carts selectByUserIdAndProductId(@Param("userId") int userId,@Param("productId") int productId);
    
    int update(@Param("carts") Carts carts);
    int updateById(@Param("cartsId") int cartsId, @Param("quantity") int quantity);
    List<Carts> selectList(@Param("uid") int uid);
}
