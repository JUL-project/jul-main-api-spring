package com.jul.project.model.vo;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class GetUserVo {

    String userId;
    String useYn;
    LocalDateTime createDtm;
    LocalDateTime updateDtm;

}
