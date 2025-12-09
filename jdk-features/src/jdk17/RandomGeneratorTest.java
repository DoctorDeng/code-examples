package jdk17;

import java.util.random.RandomGenerator;

/**
 * 练习使用增强的伪随机数生成器.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 16:12
 */
public class RandomGeneratorTest {

    static void main(String[] args) {
        var randomGenerator = RandomGenerator.of("L64X128MixRandom");
        randomGenerator.nextDouble(0, 100);
        var values = randomGenerator.doubles(0, 100)
                .limit(10)
                .boxed()
                .toList();
        System.out.println(values);
    }
}
