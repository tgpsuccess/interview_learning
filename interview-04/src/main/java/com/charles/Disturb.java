package com.charles;

/**
 * @author chales.tang
 * @title Disturb
 * @discription
 * @date 2021/7/12 10:07 下午
 */
public class Disturb {

    public static int disturbHashIdx(String key, int size) {

        return (size - 1) & (key.hashCode() ^ (key.hashCode() >>> 16));
    }

    public static int hashIdx(String key, int size) {

        return (size -1) & (key.hashCode());
    }
}
