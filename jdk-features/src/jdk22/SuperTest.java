package jdk22;

/**
 * JEP 447: Statements before super(...) 练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 11:00
 */
public class SuperTest {

    static class User {
        int age;
        public User(int age) {
            this.age = age;
        }
    }

    static class Student extends User {

        public Student(int age) {
            if (age < 5) {
                throw new IllegalArgumentException("年龄过小");
            }
            // 在调用 super 之前验证参数不会报错(java 21 及其之前会).
            super(age);
        }
    }

}
