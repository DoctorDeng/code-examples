package jdk9;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 集合、Stream、Optional 新方法练习
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 15:28
 */
public class CollectionTest {

    static void main(String[] args) {
        List<String> list = List.of("1", "2", "3");
        Map<String, Integer> map = Map.of("Hello", 1, "World", 2);

        final long count = Stream.of(1, 2, 3, 4, 5)
            .dropWhile(i -> i % 2 != 0)
            .count();
        assert count == 4;
    }

}
