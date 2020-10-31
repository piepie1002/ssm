package com.pie.ssm.respone;

import com.pie.ssm.utils.ErrorStatus;
import lombok.Builder;
import lombok.Data;

/**
 * @author LIN
 * @since JDK 1.8
 *   构建者模式
 */
@Data
@Builder
public class ResponseEntity<T> {
    private int status;
    private String message;
    private  T data;

    public ResponseEntity() {
        
    }

    public ResponseEntity(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 
     * @param data
     * @param <T>
     * @return
     */
    public static <T>ResponseEntity<T> success(T data){
        return ResponseEntity.<T>builder()
                .data(data)
                .message(ErrorStatus.SUCCESS.getMessage())
                .status(ErrorStatus.SUCCESS.getStatus()).build();
    }
    public static <T>ResponseEntity<T>success(ErrorStatus errorStatus,T data){
        return ResponseEntity.<T>builder()
                .data(data)
                .message(errorStatus.getMessage())
                .status(errorStatus.getStatus())
                .build();
    }
    public static <T> ResponseEntity<T> error() {
        return ResponseEntity.<T>builder()
                .message(ErrorStatus.SYS_ERROR.getMessage())
                .status(ErrorStatus.SYS_ERROR.getStatus())
                .build();
    }
    public static <T>ResponseEntity<T>error(ErrorStatus errorStatus){
        return ResponseEntity.<T>builder()
                .message(errorStatus.getMessage())
                .status(errorStatus.getStatus()).build();
    }
}
