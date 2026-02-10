package jdk23;

import module java.base;

/**
 * 练习导入一整个模块.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 17:29
 */
public class ImportModuleTest {

    static void main() {
        var values = Stream.of("1", "2", "3")
                .toList();
        System.out.println(values);
    }

}
