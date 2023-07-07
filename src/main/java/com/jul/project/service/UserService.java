package com.jul.project.service;

import com.jul.project.model.vo.CreateUserVo;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.model.vo.UpdateUserVo;

public interface UserService {

    GetUserVo getUser(Long userNid);

    GetUserVo createUser(CreateUserVo createUserVo);

    GetUserVo updateUser(UpdateUserVo updateUserVo);

    String deleteUser(Long userNid);

}
