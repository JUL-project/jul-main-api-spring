package com.jul.project.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {

    USER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "해당하는 유저를 찾을 수 없습니다.", "404"),
    DUPLICATE_USER_ERROR(HttpStatus.NO_CONTENT, "아이디가 중복입니다.", "204"),
    ALREADY_DELETED_USER_ERROR(HttpStatus.NOT_FOUND, "이미 삭제된 아이디입니다.", "404"),
    ;
    private final HttpStatus httpStatus;
    private final String message;
    private final String httpCode;

}
