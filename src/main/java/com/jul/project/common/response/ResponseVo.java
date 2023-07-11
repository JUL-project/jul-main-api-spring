package com.jul.project.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseVo<T> {

    private int code;
    private String message;
    private T data;

    public static <T> ResponseVo<T> success(String message, T data) {
        return new ResponseVo<>(200, message, data);
    }

    public static <T> ResponseVo<T> failed(String message, T data) {
        return new ResponseVo<>(500, message, data);
    }

}
