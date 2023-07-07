package com.jul.project.controller;

import com.jul.project.model.vo.CreateUserVo;
import com.jul.project.model.vo.GetUserVo;
import com.jul.project.model.vo.UpdateUserVo;
import com.jul.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public GetUserVo createUser(@RequestBody CreateUserVo createUserVo) {
        return userService.createUser(createUserVo);
    }

    @GetMapping("/{userNid}")
    public GetUserVo getUser(@PathVariable Long userNid) {
        return userService.getUser(userNid);
    }

    @PutMapping("")
    public GetUserVo updateUser(@RequestBody UpdateUserVo updateUserVo) {
        return userService.updateUser(updateUserVo);
    }

    @DeleteMapping("/delete/{userNid}")
    public String deleteUser(@PathVariable Long userNid) {
        return userService.deleteUser(userNid);
    }

}
