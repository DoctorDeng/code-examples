package com.doctordeng.ai.utils;

/**
 * 单位转换器, 提供通用单位转换功能支持.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/19 9:35
 */
public abstract class UnitConverter {

    private UnitConverter() {
        throw new AssertionError("Cannot instantiate UnitConverter class.");
    }

    /**
     * 将字节(byte)转换为兆字节(MB)
     *
     * @param bytes 字节数
     * @return 对应的 MB 数（四舍五入保留两位小数）
     */
    public static double byteToMB(long bytes) {
        return Math.round((bytes / (1024.0 * 1024.0)) * 100) / 100.0;
    }


}
