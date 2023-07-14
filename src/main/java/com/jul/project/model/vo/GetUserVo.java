package com.jul.project.model.vo;

import com.jul.project.model.LinkedAccount;
import com.jul.project.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetUserVo {

    Long userNId;
    String userId;
    List<LinkedAccount> linkedAccount;
    String useYn;
    LocalDateTime createDtm;
    LocalDateTime updateDtm;

    @Builder
    public GetUserVo(User user, List<LinkedAccount> linkedAccountList) {
        this.userNId = user.getUserNid();
        this.userId = user.getUserId();
        this.useYn = user.getUseYn();
        this.linkedAccount = linkedAccountList;
        this.createDtm = user.getCreateDtm();
        this.updateDtm = user.getUpdateDtm();
    }

}
