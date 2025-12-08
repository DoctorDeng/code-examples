package jdk9;

import java.io.IOException;

/**
 * 练习使用 {@link ProcessHandle} 管理进程.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 15:34
 */
public class ProcessHandleTest {

    static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
            "powershell.exe", "-Command", "ls"
        ).inheritIO();
        final ProcessHandle processHandle = processBuilder.start()
                .toHandle();
        processHandle.onExit().whenCompleteAsync((handle, throwable) -> {
            if (throwable == null) {
                System.out.println(handle.pid());
            }
            else {
                throwable.printStackTrace();
            }
        });
    }
}
