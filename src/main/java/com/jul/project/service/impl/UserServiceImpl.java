package com.jul.project.service.impl;

import com.jul.project.common.enums.CustomErrorCode;
import com.jul.project.common.exception.CustomException;
import com.jul.project.model.User;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.repository.UserRepository;
import com.jul.project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public GetUserVo getUser(Long userNid) {
        User user = userRepository.findById(userNid).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
        GetUserVo vo = new GetUserVo();
        vo.setUserId(user.getUserId());
        vo.setUseYn(user.getUseYn());
        vo.setCreateDtm(user.getCreateDtm());
        vo.setUpdateDtm(user.getUpdateDtm());
        return vo;
    }

    @Override
    public User createUser() {
        return null;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public String deleteUser() {
        return null;
    }
}
