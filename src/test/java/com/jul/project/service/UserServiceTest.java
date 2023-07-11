package com.jul.project.service;

import com.jul.project.common.exception.CustomException;
import com.jul.project.model.vo.CreateUserVo;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.model.vo.UpdateUserVo;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    private final String testId = "testid";
    private final String testPw = "testpassword";

//    @Test
//    void joinMember() {
//        CreateUserVo member = new CreateUserVo();
//        member.setUserId(testId);
//        member.setPassword(testPw);
//        GetUserVo user = userService.createUser(member);
//        Assertions.assertThat(user.getUserId()).isEqualTo(member.getUserId());
//    }
//
//    @Test
//    void getMember() {
//        CreateUserVo member = new CreateUserVo();
//        member.setUserId(testId);
//        member.setPassword(testPw);
//        GetUserVo user = userService.createUser(member);
//        GetUserVo getUser = userService.getUser(user.getUserNId());
//        Assertions.assertThat(user).isEqualTo(getUser);
//        org.junit.jupiter.api.Assertions.assertThrows(CustomException.class, () -> {
//            userService.getUser(user.getUserNId() + 12345);
//        });
//    }
//
//    @Test
//    void updateMember() {
//        CreateUserVo member = new CreateUserVo();
//        member.setUserId(testId);
//        member.setPassword(testPw);
//        GetUserVo user1 = userService.createUser(member);
//
//        UpdateUserVo updateUser = new UpdateUserVo();
//        updateUser.setUserNid(user1.getUserNId());
//        updateUser.setPassword(testPw);
//        userService.updateUser(updateUser);
//
//        GetUserVo user2 = userService.getUser(user1.getUserNId());
//        Assertions.assertThat(user1.getUserId()).isEqualTo(user2.getUserId());
//    }
//
//    @Test
//    void deleteMember() {
//        CreateUserVo member = new CreateUserVo();
//        member.setUserId(testId);
//        member.setPassword(testPw);
//        GetUserVo user = userService.createUser(member);
//        String status = userService.deleteUser(user.getUserNId());
//        Assertions.assertThat(status).isEqualTo("success");
//    }
}