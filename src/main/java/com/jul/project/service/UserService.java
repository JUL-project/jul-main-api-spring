package com.jul.project.service;

import com.jul.project.model.User;
import com.jul.project.model.vo.GetUserVo;

public interface UserService {

    GetUserVo getUser(Long userNid);

    User createUser();

    User updateUser();

    String deleteUser();

}
