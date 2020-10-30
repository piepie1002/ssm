package com.pie.ssm.utils;

import lombok.Getter;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Getter
public enum ErrorStatus {
    SUCCESS(200,"成功"),
    SYS_ERROR(40001,"系统异常"),
    SERVICE_ERROR(404,"服务异常");
    private int status;
    private String message;

    ErrorStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
