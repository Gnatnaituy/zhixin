package com.zhixin.vo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yutiantang
 * @create 2021/5/29 23:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity {

    private Boolean success;

    private String message;

    private Object data;

    public static ResponseEntity success() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.success = true;

        return responseEntity;
    }
    public static ResponseEntity success(Object data) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.success = true;
        responseEntity.data = data;

        return responseEntity;
    }

    public static ResponseEntity error(String message) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.success = true;
        responseEntity.message = message;

        return responseEntity;
    }
}
