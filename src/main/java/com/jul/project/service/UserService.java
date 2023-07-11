package com.jul.project.service;

import com.jul.project.common.response.ResponseVo;
import com.jul.project.model.vo.CreateUserVo;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.model.vo.UpdateUserVo;

public interface UserService {

    GetUserVo getUser(Long userNid);

    ResponseVo<?> createUser(CreateUserVo createUserVo);

    ResponseVo<?> updateUser(UpdateUserVo updateUserVo);

    ResponseVo<?> deleteUser(Long userNid);

}
