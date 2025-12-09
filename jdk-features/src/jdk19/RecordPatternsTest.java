package jdk19;

/**
 * 练习 Record 模式.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 17:55
 */
public class RecordPatternsTest {

    record Point(int x, int y) {
    }

    static void printSum(Object o) {
        if (o instanceof Point(int x, int y)) {
            System.out.println(x+y);
        }
    }

    static void main(String[] args) {
        var point = new Point(1, 2);
        printSum(point);
    }

}
