package com.sm.smartagriculture.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sm.smartagriculture.server.constant.R;
import com.sm.smartagriculture.server.constant.ResultCode;
import com.sm.smartagriculture.server.entity.User;
import com.sm.smartagriculture.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 * @author linorman
 * @date 2022/1/20 22:36
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @PostMapping("/add")
    public R<User> add(@RequestBody User user) {
        return userService.add(user);
    }
}
