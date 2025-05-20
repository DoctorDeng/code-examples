package com.doctordeng.ai.model;

import lombok.Data;

import java.util.Properties;

/**
 * 系统信息.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/19 9:27
 */
@Data
public class SystemInfo {

    /**
     * 最大可用内存(MB).
     */
    private double maxMemory;

    /**
     * 已分配内存(MB).
     */
    private double totalMemory;

    /**
     * 空闲内存(MB).
     */
    private double freeMemory;

    /**
     * 可用处理器数.
     */
    private int availableProcessors;

    /**
     * 系统属性.
     */
    private Properties properties;

}
