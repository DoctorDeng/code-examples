package jdk12;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DynamicConstantDesc;
import java.lang.constant.MethodTypeDesc;

/**
 * 练习使用常量 API.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 17:35
 */
public class ConstantApiTest {
    static void main(String[] args) {
        // 符号级别的类引用: 不会触发类加载、初始化.
        ClassDesc stringClass = ClassDesc.of("java.lang.String");
        // 结构化表达, 代替传统写法: (Ljava/lang/String;I)Ljava/lang/Object;
        MethodTypeDesc mtd = MethodTypeDesc.of(
                ClassDesc.of("java.lang.Object"),
                ClassDesc.of("java.lang.String"),
                ClassDesc.of("int")
        );
        System.out.println(mtd.descriptorString());
        // 动态常量（Dynamic Constant / condy）.// 常量值可以运行期计算、不再局限于：String / int / long 可以是对象、缓存对象等
        DynamicConstantDesc<?> dcd =
                DynamicConstantDesc.ofNamed(
                        ConstantDescs.BSM_INVOKE,
                        "myConst",
                        ClassDesc.of("java.lang.String")
                );
    }
}
