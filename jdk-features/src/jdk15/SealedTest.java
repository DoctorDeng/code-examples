package jdk15;

/**
 * sealed 关键字使用.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 11:21
 */
public class SealedTest {

    // 限制只能被 Student 和 Teacher 继承.
    static sealed class Person permits Student, Teacher {

    }

    // 增加 final 不允许再被继承.
    static final class Student extends Person {

    }

    // 增加 non-sealed 表示该类还可以被其他类继承.
    static non-sealed class Teacher extends Person {

    }

    static class EnglishTeacher extends Teacher {

    }

}
