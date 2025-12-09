package jdk14;

/**
 * instanceof  练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 9:36
 */
public class InstanceofTest {

    static class Student {
        public void say() {
            System.out.println("I'm student");
        }
    }

    static class Teacher {
        public void say() {
            System.out.println("I'm Teacher");
        }
    }

    static boolean isStringAndLengthOver5(Object obj) {
        return obj instanceof String s && s.length() > 5;
    }

    static void main(String[] args) {
        Object person = new Student();
        if (person instanceof Student student) {
            student.say();
        }
        else if (person instanceof Teacher teacher) {
            teacher.say();
        }
        System.out.println(isStringAndLengthOver5("sdjfladksj"));
    }

}
