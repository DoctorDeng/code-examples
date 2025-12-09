package jdk14;

import java.util.Map;

/**
 * 练习改进的 NullPointerException 提示信息.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 8:55
 */
public class ImproveNullPointerException {

    static class Account {
        String name;
        Map<String, Object> metadata;
    }

    static class User {
        Account account;
    }

    static void main() {
        User user = new User();
        // JDK14 以下版本直接报: java.lang.NullPointerException, 并不知道哪个字段导致的空指针异常.
        // JDK14 及以上版本会显示具体异常的字段, 例如:
        //      Exception in thread "main" java.lang.NullPointerException: Cannot read field "metadata" because "user.account" is null
        //	        at jdk.features/jdk14.ImproveNullPointerException.main(ImproveNullPointerException.java:26)
        System.out.println(user.account.metadata.get("create_at"));
    }
}
