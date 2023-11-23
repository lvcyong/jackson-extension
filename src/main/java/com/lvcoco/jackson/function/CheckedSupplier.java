package com.lvcoco.jackson.function;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 23:09
 */
@FunctionalInterface
public interface CheckedSupplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get() throws Throwable;
}
