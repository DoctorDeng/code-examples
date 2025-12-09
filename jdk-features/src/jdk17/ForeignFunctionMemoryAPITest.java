package jdk17;

/**
 * 练习使用外部函数与内存 API(Foreign Function & Memory API)
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 16:54
 */
public class ForeignFunctionMemoryAPITest {

    static void main(String[] args) {
        // 由于版本原因下述代码部分 API 已废弃.
//        // 1. Find foreign function on the C library path
//        MethodHandle radixSort = CLinker.getInstance().downcallHandle(
//                                     CLinker.systemLookup().lookup("radixsort"), ...);
//        // 2. Allocate on-heap memory to store four strings
//        String[] javaStrings   = { "mouse", "cat", "dog", "car" };
//        // 3. Allocate off-heap memory to store four pointers
//        MemorySegment offHeap  = MemorySegment.allocateNative(
//                                     MemoryLayout.ofSequence(javaStrings.length,
//                                                             CLinker.C_POINTER), ...);
//        // 4. Copy the strings from on-heap to off-heap
//        for (int i = 0; i < javaStrings.length; i++) {
//            // Allocate a string off-heap, then store a pointer to it
//            MemorySegment cString = CLinker.toCString(javaStrings[i], newImplicitScope());
//            MemoryAccess.setAddressAtIndex(offHeap, i, cString.address());
//        }
//        // 5. Sort the off-heap data by calling the foreign function
//        radixSort.invoke(offHeap.address(), javaStrings.length, MemoryAddress.NULL, '\0');
//        // 6. Copy the (reordered) strings from off-heap to on-heap
//        for (int i = 0; i < javaStrings.length; i++) {
//            MemoryAddress cStringPtr = MemoryAccess.getAddressAtIndex(offHeap, i);
//            javaStrings[i] = CLinker.toJavaStringRestricted(cStringPtr);
//        }
//        assert Arrays.equals(javaStrings, new String[] {"car", "cat", "dog", "mouse"});  // true
    }

}
