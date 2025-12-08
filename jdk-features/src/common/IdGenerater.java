package common;

/**
 * ID 生成器.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 11:13
 */
public interface IdGenerater {

    /**
     * 生成一个字符串格式的 ID.
     *
     * @param length ID 长度
     * @return 字符串格式的 ID
     */
    String generateStringId(int length);

}
