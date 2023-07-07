package com.jul.project.controller;

import com.jul.project.model.User;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userNid}")
    public GetUserVo getUser(@PathVariable Long userNid) {
        return userService.getUser(userNid);
    }

}
