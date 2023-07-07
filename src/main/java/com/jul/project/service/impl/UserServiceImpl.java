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
import org.springframework.http.ResponseEntity;
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
        return new GetUserVo(user);
    }

    public boolean checkUserIdDuplicate(String userId) {
        return userRepository.existsByUserId(userId);
    }

    @Override
    public GetUserVo createUser(CreateUserVo createUserVo) {
        if(checkUserIdDuplicate(createUserVo.getUserId())) {
            // TODO
            return null;
        }
        User user = new User(createUserVo);
        userRepository.saveAndFlush(user);
        return new GetUserVo(user);
    }

    @Override
    public GetUserVo updateUser(UpdateUserVo updateUserVo) {
        userRepository.findById(updateUserVo.getUserNid())
                .map(user -> {
                    user.setPassword(updateUserVo.getPassword());
                    return userRepository.saveAndFlush(user);
                }).orElseThrow(
                        () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
                );
        return getUser(updateUserVo.getUserNid());
    }

    @Override
    public String deleteUser(Long userNid) {
        User user = userRepository.findById(userNid).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
        if (user.getUseYn().equals("N")) {
            return "already deleted user";
        }
        user.setUseYn("N");
        userRepository.save(user);
        return "success";
    }
}
