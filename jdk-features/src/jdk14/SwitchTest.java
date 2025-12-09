package jdk14;

import java.util.Objects;

/**
 * Switch 表达式练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 8:33
 */
public class SwitchTest {

    static int getDayOfWeek(String day) {
        return switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default -> 0;
        };
    }


    static void main(String[] args) {
        String day = "WEDNESDAY";
        int result = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY": yield  6;
            case "TUESDAY": yield 7;
            case "THURSDAY", "SATURDAY": yield 8;
            case "WEDNESDAY": yield 9;
            default: yield 0;
        };
        System.out.println(Objects.equals(result, getDayOfWeek(day)));
    }
}
