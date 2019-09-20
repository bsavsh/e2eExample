package com.savsh.utils;

public class IdGeneratorUtils {
    private static long id = 1;

    public static synchronized long nextId() {
        return id++;
    }
}
