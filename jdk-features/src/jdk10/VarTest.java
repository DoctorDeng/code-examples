package jdk10;

import java.util.List;

/**
 * 练习局部变量类型推断(var 关键词).
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 16:23
 */
public class VarTest {

    static void main(String[] args) {
        var userName = "张三";
        var sequence = List.of(1, 2, 3, 4);
        for (var value: sequence) {
            System.out.println(value);
        }
    }
}
