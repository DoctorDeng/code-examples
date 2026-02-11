package jdk25;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StableValue 使用练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/11 15:37
 */
public class StableValueTest {

    /**
     * {@link StableValue} 是 JDK 25 的预览 API, 后续可能会变动.
     */
    private static final StableValue<Logger> logger = StableValue.of();

    static Logger getLogger() {
        return logger.orElseSet(() -> Logger.getLogger(StableValueTest.class.getName()));
    }

    static void main() {
        getLogger().log(Level.INFO, "Hello World");
    }

}
