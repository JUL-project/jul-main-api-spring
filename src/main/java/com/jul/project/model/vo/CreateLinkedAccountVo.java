package com.jul.project.model.vo;

import com.jul.project.model.User;
import lombok.Data;

@Data
public class CreateLinkedAccountVo {

    User userNid;
    String platform;
    String accessToken;
    String refreshToken;

}
