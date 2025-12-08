package common;

import java.util.concurrent.ThreadLocalRandom;

/**
 * {@link IdGenerater} 的标准实现.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 11:14
 */
public class GenericIdGenerater implements IdGenerater {
    /**
     * 字符集：大小写字母 + 数字.
     */
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public String generateStringId(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        StringBuilder sb = new StringBuilder();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }

}
