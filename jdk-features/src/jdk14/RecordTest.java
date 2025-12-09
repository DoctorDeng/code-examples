package jdk14;

import java.util.Arrays;

/**
 * Recorder 练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 10:21
 */
public class RecordTest {

    record Student(String name, int age) {

    }

    static void main(String[] args) {
        Student student = new Student("张三", 99);
        System.out.println(student);
        System.out.println(student.name());
        System.out.println(Student.class.isRecord());
        System.out.println(Arrays.toString(Student.class.getRecordComponents()));
    }

}
