package com.sm.smartagriculture.server.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 传感器数据
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Data
@TableName("sensor_data")
public class SensorData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    // 传感器类型
    // 温度：temperature
    // 湿度：humidity
    // 光照：illumination
    private String type;
    private int deviceId;
    private double value;
    private char unit;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
