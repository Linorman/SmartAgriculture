package com.sm.smartagriculture.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.smartagriculture.server.constant.R;
import com.sm.smartagriculture.server.constant.ResultCode;
import com.sm.smartagriculture.server.entity.SensorData;
import com.sm.smartagriculture.server.dao.SensorDataMapper;
import com.sm.smartagriculture.server.service.SensorDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 传感器数据service实现类
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Slf4j
@Service
public class SensorDataServiceImpl extends ServiceImpl<SensorDataMapper, SensorData> implements SensorDataService {
    @Autowired
    private SensorDataMapper sensorDataMapper;

    /**
     * 获取传感器数据
     * @return
     */
    @Override
    public R<SensorData[]> data() {
        LambdaQueryWrapper<SensorData> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SensorData::getType, "temperature").orderByDesc(SensorData::getCreateTime);
        SensorData sensorDataTemp = sensorDataMapper.selectOne(wrapper);
        wrapper.clear();
        wrapper.eq(SensorData::getType, "humidity").orderByDesc(SensorData::getCreateTime);
        SensorData sensorDataHum = sensorDataMapper.selectOne(wrapper);
        wrapper.clear();
        wrapper.eq(SensorData::getType, "illumination").orderByDesc(SensorData::getCreateTime);
        SensorData sensorDataLight = sensorDataMapper.selectOne(wrapper);
        if (sensorDataTemp == null) {
            log.info("Temperature数据为空");
            return R.result(ResultCode.RECORD_NOT_EXIST, null);
        }
        if (sensorDataHum == null) {
            log.info("Humidity数据为空");
            return R.result(ResultCode.RECORD_NOT_EXIST, null);
        }
        if (sensorDataLight == null) {
            log.info("Light数据为空");
            return R.result(ResultCode.RECORD_NOT_EXIST, null);
        }
        SensorData[] sensorData = {sensorDataTemp, sensorDataHum, sensorDataLight};

        log.info("传感器数据:{}", (Object) sensorData);
        return R.result(ResultCode.DATABASE_SUCCESS, sensorData);
    }

    /**
     * 获取传感器历史数据
     * @return
     */
    @Override
    public R<List<List<SensorData>>> history() {
        LambdaQueryWrapper<SensorData> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SensorData::getType, "temperature").orderByDesc(SensorData::getCreateTime);
        List<SensorData> tempDataList = sensorDataMapper.selectList(wrapper);
        wrapper.clear();
        wrapper.eq(SensorData::getType, "humidity").orderByDesc(SensorData::getCreateTime);
        List<SensorData> humDataList = sensorDataMapper.selectList(wrapper);
        wrapper.clear();
        wrapper.eq(SensorData::getType, "illumination").orderByDesc(SensorData::getCreateTime);
        List<SensorData> lightDataList = sensorDataMapper.selectList(wrapper);
        if (tempDataList == null) {
            log.info("Temperature历史数据为空");
            return R.result(ResultCode.RECORD_NOT_EXIST, null);
        }
        if (humDataList == null) {
            log.info("Humidity历史数据为空");
            return R.result(ResultCode.RECORD_NOT_EXIST, null);
        }
        if (lightDataList == null) {
            log.info("Light历史数据为空");
            return R.result(ResultCode.RECORD_NOT_EXIST, null);
        }
        ArrayList<List<SensorData>> sensorData = new ArrayList<>();
        sensorData.add(tempDataList);
        sensorData.add(humDataList);
        sensorData.add(lightDataList);

        log.info("传感器历史数据:{}", sensorData);
        return R.result(ResultCode.DATABASE_SUCCESS, sensorData);
    }
}
