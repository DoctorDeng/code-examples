package jdk11;

import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * JFR 自定义事件练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 17:05
 */
public class JfrTest {

    @Label("Hello World")
    @Description("Helps the programmer getting started")
    static class HelloWorld extends Event {
        @Label("Message")
        String message;
    }

    static void main(String[] args) throws IOException {
        // 启动增加参数: -XX:StartFlightRecording=duration=1s,filename=recording.jfr
        HelloWorld event = new HelloWorld();
        event.message = "hello, world!";
        event.commit();

        System.out.println(Paths.get(".").toAbsolutePath());
        final Path path = Paths.get("./recording.jfr");
        final List<RecordedEvent> recordedEvents = RecordingFile.readAllEvents(path);
        for (RecordedEvent _event : recordedEvents) {
            System.out.println(_event.getStartTime() + ", " + _event.getEventType().getName());
        }
    }

}
