package com.jul.project.service.impl;

import com.jul.project.common.enums.CustomErrorCode;
import com.jul.project.common.exception.CustomException;
import com.jul.project.model.User;
import com.jul.project.model.vo.CreateUserVo;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.model.vo.UpdateUserVo;
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
    public GetUserVo createUser(CreateUserVo createUserVo) {
        // need userid duplicate check
        User user = new User();
        user.setUserId(createUserVo.getUserId());
        user.setPassword(createUserVo.getPassword());
        user.setUseYn("Y");
        return getUser(userRepository.save(user).getUserNid());
    }

    @Override
    public GetUserVo updateUser(UpdateUserVo updateUserVo) {
        User user = userRepository.findById(updateUserVo.getUserNid()).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
        user.setPassword(updateUserVo.getPassword());
        return getUser(userRepository.save(user).getUserNid());
    }

    @Override
    public String deleteUser(Long userNid) {
        User user = userRepository.findById(userNid).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
        user.setUseYn("N");
        userRepository.save(user);
        return "N";
    }
}
