package jdk17;

/**
 * 练习 Switch Pattern 模式.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 16:36
 */
public class SwitchPatternTest {

    static String getTypeName(Object obj) {
        return switch (obj) {
            case String s -> "String";
            case Integer i -> "Integer";
            case Double d -> "Double";
            case null -> "Null";
            default -> "Unknown";
        };
    }

    static void main(String[] args) {
        System.out.println(getTypeName(null));
        System.out.println(getTypeName("上空的飞机"));
    }
}
