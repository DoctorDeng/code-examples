package com.doctordeng.ai.service;

import com.doctordeng.ai.model.SystemInfo;

/**
 * 应用 Service, 提供应用通用方法.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/19 9:26
 */
public interface ApplicationService {

    /**
     * 获取当前应用系统信息.
     */
    SystemInfo getSystemInfo();

}
