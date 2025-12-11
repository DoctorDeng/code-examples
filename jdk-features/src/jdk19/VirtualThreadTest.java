package jdk19;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Virtual Thread(虚拟线程) 使用练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/11 8:21
 */
public class VirtualThreadTest {

    private static final System.Logger LOGGER = System.getLogger(VirtualThreadTest.class.getSimpleName());

    static void main(String[] args) {
        // 创建虚拟线程 Executor, 由于虚拟线程非常轻量, 可以无限制的创建, 因此没有传统线程池的核心线程数、最大线程数、队列等参数.
        try(var executor = Executors.newVirtualThreadPerTaskExecutor();
            var httpClient = HttpClient.newBuilder()
                    .executor(executor)
                    .build()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.baidu.com"))
                    .header("Content-Type", "application/html")
                    .build();
            var futures = IntStream.range(0, 100).boxed()
                    .map(i -> httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)))
                    .toArray(CompletableFuture[]::new);
            CompletableFuture<Void> all = CompletableFuture.allOf(futures);
            all.join();
            for (var future: futures) {
                try {
                    HttpResponse<String> response = (HttpResponse<String>) future.get();
                    System.out.println(response.body());
                }
                catch (InterruptedException | ExecutionException e) {
                    LOGGER.log(System.Logger.Level.WARNING, "请求发生错误", e);
                }
            }
        }
    }

}
