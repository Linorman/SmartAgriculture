package com.sm.smartagriculture.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.smartagriculture.server.constant.R;
import com.sm.smartagriculture.server.constant.ResultCode;
import com.sm.smartagriculture.server.entity.User;
import com.sm.smartagriculture.server.dao.UserMapper;
import com.sm.smartagriculture.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 用户service实现类
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @Override
    public R<User> login(User user) {
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User temp = userMapper.selectOne(queryWrapper);
        log.info("temp:{}", temp);
        if (temp == null) {
            log.info("用户不存在");
            return R.result(ResultCode.USER_NOT_EXIST, null);
        }
        if (!password.equals(temp.getPassword())) {
            log.info("密码错误");
            return R.result(ResultCode.USER_PASSWORD_ERROR, null);
        }
        if (temp.getStatus() == 0) {
            log.info("用户已被禁用");
            return R.result(ResultCode.USER_ACCOUNT_LOCKED, null);
        }
        log.info("用户登陆成功{}", temp);
        return R.result(ResultCode.USER_SUCCESS, temp);
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @Override
    public R<User> add(User user) {
        return null;
    }
}
