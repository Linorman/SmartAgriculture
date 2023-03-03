package com.sm.smartagriculture.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.smartagriculture.server.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
