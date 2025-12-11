package jdk19;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;

/**
 * Structured Concurrency(结构化并发)练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/11 9:34
 */
public class StructuredConcurrencyTest {

    static void printSearchWebsite() {
        // 注意：结构化并发 API 从 JDK 21 首次提出至当前 JDK25 还在预览阶段, API 后续可能变动.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor();
             var httpClient = HttpClient.newBuilder()
                     .executor(executor)
                     .build();
             var scope = StructuredTaskScope.open()) {
            StructuredTaskScope.Subtask<String> baiduHtml = scope.fork(() -> httpClient.sendAsync(HttpRequest.newBuilder()
                            .uri(URI.create("https://www.baidu.com"))
                            .header("Content-Type", "application/html")
                            .build(), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .join()
                    .body());
            StructuredTaskScope.Subtask<String> _360Html = scope.fork(() -> httpClient.sendAsync(HttpRequest.newBuilder()
                            .uri(URI.create("https://www.so.com/"))
                            .header("Content-Type", "application/html")
                            .build(), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .join()
                    .body());
            scope.join();
            System.out.println(baiduHtml.get());
            System.out.println(_360Html.get());
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void main(String[] args) {
        printSearchWebsite();
    }

}
