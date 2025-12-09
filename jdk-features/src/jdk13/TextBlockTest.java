package jdk13;

/**
 * 练习文本块(Text Block).
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 8:24
 */
public class TextBlockTest {

    static void main(String[] args) {
        String textBlock = """
                <html>
                    <body>
                        <p>Hello World!</p>
                    </body>
                </html>
                """;
        System.out.println(textBlock);
    }
}
