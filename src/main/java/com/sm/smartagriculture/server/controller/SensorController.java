package com.sm.smartagriculture.server.controller;

import com.sm.smartagriculture.server.constant.R;
import com.sm.smartagriculture.server.entity.SensorData;
import com.sm.smartagriculture.server.service.SensorDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 传感器数据
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Slf4j
@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    private SensorDataService sensorDataService;

    /**
     * 获取传感器数据
     * @return
     */
    @GetMapping("/data")
    public R<SensorData[]> data() {
        return sensorDataService.data();
    }

    /**
     * 获取历史传感器数据
     * @return
     */
    @GetMapping("/history")
    public R<List<List<SensorData>>> history() {
        return sensorDataService.history();
    }
}
