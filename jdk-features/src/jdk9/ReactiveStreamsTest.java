package jdk9;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * 响应式流练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 15:50
 */
public class ReactiveStreamsTest {

    private static final System.Logger LOGGER = System.getLogger("ReactiveStreamsTest");

    static void main(String[] args) throws InterruptedException {
        // 使用 Java 9 内置的 SubmissionPublisher（实现了 Publisher）
        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
            // 创建订阅者.
            MySubscriber subscriber = new MySubscriber("Subscriber-1");
            // 订阅.
            publisher.subscribe(subscriber);
            // 发布数据
            LOGGER.log(System.Logger.Level.INFO, "发布数据开始...");
            for (int i = 1; i <= 5; i++) {
                System.out.println("发布: " + i);
                publisher.submit(i);
                Thread.sleep(200);
            }
            // 关闭 publisher（会触发 onComplete）
            publisher.close();
            // 等待完成
            Thread.sleep(1000);
        }
    }

    static class MySubscriber implements Flow.Subscriber<Integer> {
        private Flow.Subscription subscription;
        private final String name;
        MySubscriber(String name) {
            this.name = name;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            LOGGER.log(System.Logger.Level.INFO, name + ": 订阅成功，请求1个元素");
            subscription.request(1);
        }

        @Override
        public void onNext(Integer item) {
            LOGGER.log(System.Logger.Level.INFO, name + ": 接收到 " + item);
            // 模拟处理耗时.
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 请求下一个元素.
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            LOGGER.log(System.Logger.Level.ERROR, name + ": 发生错误: " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            LOGGER.log(System.Logger.Level.INFO, name + ": 数据流完成");
        }
    }
}
