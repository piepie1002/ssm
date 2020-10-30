package com.pie.ssm.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Getter
@Setter
public class ServiceException extends RuntimeException{
    private int status;

    public ServiceException(String message, int status) {
        super(message);
        this.status = status;
    }
}
