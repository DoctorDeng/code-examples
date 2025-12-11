package jdk21;

/**
 * String Templates(字符串模板)练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/11 11:04
 */
public class StringTemplatesTest {

    record User(String name, int age) {
    }


    static void main(String[] args) {
        // 字符串模板功能在 JDK 23 时功能已被撤回.
//        var user = new User("张三", 100);
//        var code = 12312;
//        String message = STR."{user.name} 您好, 验证码是: {code}";
//        System.out.println(message);
    }

}
