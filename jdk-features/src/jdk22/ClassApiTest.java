package jdk22;

import java.lang.classfile.ClassFile;
import java.lang.classfile.CodeBuilder;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;

import static java.lang.constant.ConstantDescs.CD_void;

/**
 * Class API 练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 16:06
 */
public class ClassApiTest {
    static void main() {
        // 创建一个 Hello 类.
        byte[] bytes = ClassFile.of().build(
            ClassDesc.of("Hello"),
            cb -> {
                cb.withFlags(ClassFile.ACC_PUBLIC);
                cb.withMethod("say", MethodTypeDesc.of(CD_void), ClassFile.ACC_STATIC,
                    mb -> mb.withCode(CodeBuilder::return_)
                );
            }
        );
    }
}
