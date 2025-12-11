package jdk20;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Scoped Values(作用域值)练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/11 10:11
 */
public class ScopedValuesTest {
    static final ScopedValue<Date> STATE_TIME_SCOPE = ScopedValue.newInstance();

    static void printRequestStartTime() {
        Date startTime = STATE_TIME_SCOPE.get();
        System.out.println("请求开始时间: " + startTime + " 完成时间: " + new Date());
    }

    static void main(String[] args) {
        ScopedValue.where(STATE_TIME_SCOPE, new Date())
                // 每个 Scoped Value 被绑定时执行的函数.
                .run(() -> {
                    try {
                        // 模拟执行业务操作.
                        try {
                            TimeUnit.MILLISECONDS.sleep(3);
                        }
                        catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    finally {
                        // 业务执行完成打印请求开始时间.
                        printRequestStartTime();
                    }
                });
    }
}
