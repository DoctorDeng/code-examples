package com.doctordeng.ai.service.impl;

import com.doctordeng.ai.model.SystemInfo;
import com.doctordeng.ai.service.ApplicationService;
import com.doctordeng.ai.utils.UnitConverter;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * {@link ApplicationService} 默认实现.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/19 9:32
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public SystemInfo getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        Runtime runtime = Runtime.getRuntime();
        Properties properties = System.getProperties();

        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        int availableProcessors = runtime.availableProcessors();

        systemInfo.setMaxMemory(UnitConverter.byteToMB(maxMemory));
        systemInfo.setTotalMemory(UnitConverter.byteToMB(totalMemory));
        systemInfo.setFreeMemory(UnitConverter.byteToMB(freeMemory));
        systemInfo.setAvailableProcessors(availableProcessors);
        systemInfo.setProperties(properties);
        return systemInfo;
    }

}
