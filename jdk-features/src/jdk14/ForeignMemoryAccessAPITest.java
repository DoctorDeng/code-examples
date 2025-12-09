package jdk14;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

/**
 * 练习使用 Foreign-Memory Access API 访问堆外内存.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 10:34
 */
public class ForeignMemoryAccessAPITest {

    record Student(String name, int age) {
    }

    static void main(String[] args) {
        // JDK 21 中 Foreign Function & Memory API 称为正式 API, MemoryHandles 等已被废弃.
//        // 获取内存访问var句柄
//        var handle = MemoryHandles.varHandle(char.class,
//                ByteOrder.nativeOrder());
//        // 申请200字节的堆外内存
//        try (MemorySegment segment = MemorySegment.allocateNative(200)) {
//            for (int i = 0; i < 25; i++) {
//                handle.set(segment, i << 2, (char) (i + 1 + 64));
//                System.out.println(handle.get(segment, i << 2));
//            }
//        }
        // JDK21+ 版本.
        // 使用 Arena 管理内存生命周期
        try (Arena arena = Arena.ofConfined()) {
            // 分配内存
            MemorySegment segment = arena.allocate(100); // 分配100字节
            // 创建 VarHandle 来访问内存
            ValueLayout.OfInt intLayout = ValueLayout.JAVA_INT;
            VarHandle intHandle = intLayout.varHandle();
            // 写入数据
            intHandle.set(segment, 0, 42);           // 在偏移量0处写入int
            intHandle.set(segment, 4, 100);          // 在偏移量4处写入int
            // 读取数据
            int value1 = (int) intHandle.get(segment, 0);
            int value2 = (int) intHandle.get(segment, 4);
            System.out.println("Value at offset 0: " + value1);  // 42
            System.out.println("Value at offset 4: " + value2);  // 100
            // 批量操作.
            MemorySegment arraySegment = arena.allocate(
                intLayout.byteSize() * 5,  // 5个int的空间
                intLayout.byteAlignment()            // 对齐要求
            );
            // 使用 MemorySegment 的 API 批量设置值
            for (int i = 0; i < 5; i++) {
                arraySegment.setAtIndex(intLayout, i, i * 10);
            }
            // 批量读取
            for (int i = 0; i < 5; i++) {
                System.out.println("Array[" + i + "] = " +
                    arraySegment.getAtIndex(intLayout, i));
            }
        }
    }
}
