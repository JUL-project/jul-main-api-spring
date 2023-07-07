package com.jul.project.common.exception;

import com.jul.project.common.enums.CustomErrorCode;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class CustomErrorResponseEntity {
    private int status;
    private String code;
    private String message;

    public static ResponseEntity<CustomErrorResponseEntity> toResponseEntity(CustomErrorCode e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(CustomErrorResponseEntity.builder()
                        .status(e.getHttpStatus().value())
                        .code(e.name())
                        .message(e.getMessage())
                        .build()
                );
    }
}
