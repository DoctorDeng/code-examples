package com.doctordeng.ai.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

/**
 * 基础数学计算 Service.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/16 17:19
 */
@Service
public class MathService {

    @Tool(description = "计算 a 和 b 两个数之和")
    public String add(Double a, Double b) {
        return String.valueOf(a + b);
    }

}
