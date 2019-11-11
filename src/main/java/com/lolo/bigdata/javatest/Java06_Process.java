package com.lolo.bigdata.javatest;

/**
 * @Auther: gordon    Email:gordon_ml@163.com
 * @Date: 11/11/2019
 * @Description: 演示字符串的 ==
 * @version: 1.0
 */
public class Java06_Process {

    public static void main(String[] args) {

        String s = "a";
        if (s == "a") {
            System.out.println("true");  // true
        } else {
            System.out.println("false");
        }

        String s1 = new String("a");  // 新的对象
        if (s1 == "a") {
            System.out.println("true");
        } else {
            System.out.println("false");  // false
        }

        String s2 = "abc".substring(0, 1);  // 创建新的
        if (s2 == "a") {
            System.out.println("true");
        } else {
            System.out.println("false");  // false
        }

        String s3 = "a".substring(0, 1);  // 没有创建新的
        if (s3 == "a") {
            System.out.println("true");  // true
        } else {
            System.out.println("false");
        }
    }
}
