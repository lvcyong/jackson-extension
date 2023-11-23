package com.lvcoco.jackson.function;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 23:11
 */
public class FunctionHelper {
    public static <T> T wrap(CheckedSupplier<T> checkedSupplier) {
        try {
            return checkedSupplier.get();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
