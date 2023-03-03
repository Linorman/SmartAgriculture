package com.sm.smartagriculture.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.smartagriculture.server.constant.R;
import com.sm.smartagriculture.server.entity.SensorData;

import java.util.List;

/**
 * 传感器数据service接口
 * @author linorman
 * @date 2020/7/15 10:45
 */
public interface SensorDataService extends IService<SensorData> {
    R<SensorData[]> data();

    R<List<List<SensorData>>> history();
}
