package jdk21;

/**
 * 未命名模式练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 9:49
 */
public class UnnamedPatternTest {

    static void main(String[] args) {
        try {
            if (true) {
                throw new IllegalArgumentException("参数错误");
            }
        }
        catch (Exception _) {
            // ignore.
        }
    }

}
