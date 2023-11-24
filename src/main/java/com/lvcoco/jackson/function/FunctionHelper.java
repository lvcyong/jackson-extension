package com.lvcoco.jackson.function;

import io.vavr.CheckedFunction0;

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
    public static <T> T wrap(CheckedFunction0<T> checkedFunction0) {
        try {
            return checkedFunction0.apply();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
