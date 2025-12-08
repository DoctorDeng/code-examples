package jdk9;

import java.util.logging.Logger;

/**
 * 练习使用 {@link Logger}.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 15:45
 */
public class LoggerTest {

    private static final System.Logger LOGGER = System.getLogger("LoggerTest");

    static void main(String[] args) {
        LOGGER.log(System.Logger.Level.INFO, "Hello World!");
        LOGGER.log(System.Logger.Level.WARNING, "Hello World!");
    }

}
