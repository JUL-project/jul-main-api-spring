package com.jul.project.service;

import com.jul.project.model.LinkedAccount;
import com.jul.project.model.User;
import com.jul.project.model.vo.CreateLinkedAccountVo;

public interface LinkedAccountService {

    LinkedAccount getLinkedAccount(User userNid);

    LinkedAccount createLinkedAccount(User userNid, CreateLinkedAccountVo linkedAccountVo);

    LinkedAccount updateLinkedAccount(User userNid);

    String deleteLinkedAccount(User userNid);

}
