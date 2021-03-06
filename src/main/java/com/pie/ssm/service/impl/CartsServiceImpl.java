package com.pie.ssm.service.impl;

import com.pie.ssm.entity.Carts;
import com.pie.ssm.exception.ServiceException;
import com.pie.ssm.mapper.CartsMapper;
import com.pie.ssm.request.CartsDto;
import com.pie.ssm.service.CartsService;
import com.pie.ssm.utils.ColaBeanUtils;
import com.pie.ssm.vo.CartsVo;
import com.pie.ssm.vo.ListDataVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.pie.ssm.utils.ErrorStatus.SERVICE_ERROR;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Service
public class CartsServiceImpl implements CartsService {
    @Resource
    private CartsMapper cartsMapper;
    @Override
    public int saveCarts(CartsDto cartsDto) {
        //涉及请求参数跟持久化对象的转化问题
        int temp = 0;
        try {
            Carts carts = cartsMapper.selectByUserIdAndProductId(cartsDto.getUserId(),cartsDto.getProductId());
            //判断是否为空
            if (carts!=null){
                int quantity =carts.getQuantity()+ cartsDto.getQuantity();
                temp=cartsMapper.updateById(carts.getCartsId(),quantity);
            }else {
                carts = cartsMapper.selectCartsStatus(cartsDto.getUserId(), cartsDto.getProductId());
                if (carts!=null){
                    BeanUtils.copyProperties(cartsDto,carts);
                    temp = cartsMapper.updateStatus(carts);
                }else{
                    carts = new Carts();
                    /*
                     * 将对象的属性拷贝到另一个对象
                     * 1.属性类型名称要保持一致
                     * 参数
                     * 参数 要拷贝的对象
                     * 参数 目标对象
                     * */
                    BeanUtils.copyProperties(cartsDto,carts);
                    temp=cartsMapper.insert(carts);
                }
            }
        }catch (Exception e){
            throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
        return temp;
    }

    @Override
    public ListDataVo findAllCarts(int uId) {
        ListDataVo listDataVo = new ListDataVo();
        List<Carts> cartsList = cartsMapper.selectList(uId);
        List<CartsVo>cartsVos = ColaBeanUtils.copyListProperties(cartsList,CartsVo::new);
        listDataVo.setCartsVoList(cartsVos);
        return listDataVo;
    }

    @Override
    public ListDataVo deleteCarts(CartsDto cartsDto) {
        //先判断是否为空
        int temp = 0;
        try {
            Carts carts = cartsMapper.selectByUserIdAndProductId(cartsDto.getUserId(), cartsDto.getProductId());
            if (carts!=null){
                temp = cartsMapper.update(carts);
                if (temp > 0){
                    return findAllCarts(cartsDto.getUserId());
                }else {
                    throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
                }
            }else {
                return findAllCarts(cartsDto.getUserId());
            }
        }catch (Exception e){
            throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
    }

    @Override
    public ListDataVo updateQuantity(CartsDto cartsDto) {
        Carts carts = cartsMapper.selectByUserIdAndProductId(cartsDto.getUserId(), cartsDto.getProductId());
        if (carts!=null){
            int quantity = carts.getQuantity()+cartsDto.getQuantity();
            if (quantity>0){
                int temp = cartsMapper.updateById(carts.getCartsId(), quantity);
                if (temp>0){
                    return findAllCarts(cartsDto.getUserId());
                }else {
                    throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
                }
            }else {
                int temp = cartsMapper.update(carts);
                if (temp>0){
                    return findAllCarts(cartsDto.getUserId());
                }else {
                    throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
                }
            }
        }
        return findAllCarts(cartsDto.getUserId());
    }

}
