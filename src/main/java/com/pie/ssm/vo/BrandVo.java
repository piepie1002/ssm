package com.pie.ssm.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BrandVo<T> implements Serializable {
    private Long brandId;
    private String brandName;
    private Integer status;
    private List<T> dataList;
}

