package com.lolo.bigdata.javatest;

import java.lang.reflect.Field;

public class Java03_Var_2 {

    public static void main(String[] args) throws Exception {

        // 字面量（不可修改的变量）
        final String name = "gql";

        // String, StringBuilder, StringBuffer

        // String 不可变字符串
        String s = " a b ";

        s.trim();  // 产生新的字符串
        System.out.println("!" + s + "!"); // ! a b !


        // 其实通过反射绕过也可以改变
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        char[] cs = (char[]) value.get(s);  //  adb
        cs[2] = 'd';
        System.out.println(s);

        // 隐式类型转换
        byte bb = 10;
        short ss = 20;
        //ss = ss + bb;  // 底层汇编指令共255个 add统一加后 int
        ss += bb;  // 可以，使用原始精度保存
        bb += ss;  // 可以，使用原始精度保存
        System.out.println(bb + ", " + ss);
    }
}
