package com.jul.project.model.vo;

import com.jul.project.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class GetUserVo {

    Long userNId;
    String userId;
    String useYn;
    LocalDateTime createDtm;
    LocalDateTime updateDtm;

    @Builder
    public GetUserVo(User user) {
        this.userNId = user.getUserNid();
        this.userId = user.getUserId();
        this.useYn = user.getUseYn();
        this.createDtm = user.getCreateDtm();
        this.updateDtm = user.getUpdateDtm();
    }

}
