package com.zc.eshop.common.utils;

import java.util.function.Supplier;

public class ObjectUtil {


    public static <T> T getNotNull(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
