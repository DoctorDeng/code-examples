package jdk11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * 练习使用 {@link java.net.http.HttpClient}.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 16:40
 */
public class HttpClientTest {

    static void main(String[] args) {
        try (HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(60))
                .build();) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.baidu.com/"))
                    .header("Content-Type", "text/html")
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
        }
    }
}
