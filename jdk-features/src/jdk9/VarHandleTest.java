package jdk9;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * 变量句柄练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/8 16:05
 */
public class VarHandleTest {

    private static final System.Logger LOGGER = System.getLogger(VarHandleTest.class.getSimpleName());

    static class Counter {
        public int count = 0;
    }

    static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Counter counter = new Counter();
        VarHandle varHandle = MethodHandles
            .lookup()
            .findVarHandle(Counter.class, "count", int.class);
        LOGGER.log(System.Logger.Level.INFO, varHandle.get(counter));
        counter.count++;
        LOGGER.log(System.Logger.Level.INFO, varHandle.getVolatile(counter));
        LOGGER.log(System.Logger.Level.INFO, varHandle.getOpaque(counter));
        LOGGER.log(System.Logger.Level.INFO, varHandle.getAcquire(counter));
    }

}
