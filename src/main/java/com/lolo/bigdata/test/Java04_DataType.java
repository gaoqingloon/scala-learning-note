package com.lolo.bigdata.test;

/**
 * 方法重载的顺序
 */
public class Java04_DataType {

    public static void main(String[] args) {

        // 方法的重载，参数列表不同（类型，个数，顺序）
        byte b = 10;

        // byte(1) -> short(2) -> int(4)
        // char(2) 0~65535 没有负数，无法替换
        // 基本数据类型考虑的是数据的精度
        test(b);
    }

    private static void test(int i) {
        System.out.println("iiiii");
    }

    /*private static void test(short s) {
        System.out.println("sssss");
    }*/

    /*private static void test(byte b) {
        System.out.println("bbbbb");
    }*/

    private static void test(char c) {
        System.out.println("ccccc");
    }
}
