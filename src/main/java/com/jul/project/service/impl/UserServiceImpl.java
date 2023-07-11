package com.jul.project.service.impl;

import com.jul.project.common.enums.CustomErrorCode;
import com.jul.project.common.exception.CustomException;
import com.jul.project.common.response.ResponseVo;
import com.jul.project.model.User;
import com.jul.project.model.vo.CreateUserVo;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.model.vo.UpdateUserVo;
import com.jul.project.repository.UserRepository;
import com.jul.project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

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
    public ResponseVo<?> createUser(CreateUserVo createUserVo) {
        if (checkUserIdDuplicate(createUserVo.getUserId())) {
            return ResponseVo.failed("DUPLICATED USER ID", createUserVo);
        }
        User user = mapper.map(createUserVo, User.class);
        userRepository.saveAndFlush(user);
        return ResponseVo.success("CREATE SUCCESS", user);
    }

    @Override
    public ResponseVo<?> updateUser(UpdateUserVo updateUserVo) {
        userRepository.findById(updateUserVo.getUserNid())
                .map(user -> {
                    user.setPassword(updateUserVo.getPassword());
                    return userRepository.saveAndFlush(user);
                }).orElseThrow(
                        () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
                );
        return ResponseVo.success("UPDATE SUCCESS", null);
    }

    @Override
    public ResponseVo<?> deleteUser(Long userNid) {
        User user = userRepository.findById(userNid).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
        if (user.getUseYn().equals("N")) throw new CustomException(CustomErrorCode.ALREADY_DELETED_USER_ERROR);
        user.setUseYn("N");
        userRepository.save(user);
        return ResponseVo.success("DELETE SUCCESS", user.getUseYn());
    }
}
