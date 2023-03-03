package com.sm.smartagriculture.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.smartagriculture.server.constant.R;
import com.sm.smartagriculture.server.entity.User;

/**
 * 用户service接口
 * @author linorman
 * @date 2022/12/23 10:45
 */
public interface UserService extends IService<User> {
    R<User> login(User user);

    R<User> add(User user);
}
