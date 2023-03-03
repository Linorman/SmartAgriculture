package com.sm.smartagriculture.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.smartagriculture.server.entity.SensorData;
import org.apache.ibatis.annotations.Mapper;

/**
 * 传感器mapper
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Mapper
public interface SensorDataMapper extends BaseMapper<SensorData> {
}
