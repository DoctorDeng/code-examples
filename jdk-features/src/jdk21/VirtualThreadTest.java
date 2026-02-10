package jdk21;

import java.util.concurrent.TimeUnit;

/**
 * 继续练习虚拟线程（Virtual Thread）
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 9:59
 */
public class VirtualThreadTest {

    static void main() {
        var thread = Thread.ofVirtual().name("虚拟线程")
                .inheritInheritableThreadLocals(false)
                .uncaughtExceptionHandler((t, e)-> {
                    System.out.println("线程: " + t.getName() + " 执行发生错误: " + e.getMessage());
                }).start(() -> {
                    if (true) {
                        throw new IllegalArgumentException("参数错误");
                    }
                });
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
