package com.jul.project.common.exception;

import com.jul.project.common.enums.CustomErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    CustomErrorCode errorCode;
}
