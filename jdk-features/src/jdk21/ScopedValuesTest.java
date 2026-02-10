package jdk21;

import java.util.Date;

/**
 * Scoped Value 练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 10:16
 */
public class ScopedValuesTest {
    final  static ScopedValue<Date> V = ScopedValue.newInstance();

    static void main() {
        ScopedValue.where(V, new Date())
                .run(() -> {
                    System.out.println(Thread.currentThread().getName() + " 查询日期:" + V.get());
                });
    }
}
