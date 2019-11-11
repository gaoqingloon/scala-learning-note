package com.lolo.bigdata.javatest;

public class Java05_Operator {

    public static void main(String[] args) {

        // 运算
//        int i = 0;
//        int j = i++;
//        int k = ++i;
//        System.out.println(i + ", " + j + ", " + k);  //2, 0, 2

        int m = 0;
        m = m++; // 赋值：等号右边的计算结果给左边
        // 1. (_a = m++), 2. i = _a
        // 3. _a = 0, i = 1
        // 4. i = _a = 0
        System.out.println(m);  //0

        /* 反编译 .class
        public static void main(String[] args) {
            int i = 0;
            int i = i + 1;
            ++i;
            System.out.println(i + ", " + i + ", " + i);
            int m = 0;
            int var6 = m + 1;
            System.out.println(m);
        }
         */

        byte b = 1;
        b += 1;  // java 允许
        //b = b + 1;  // 编译失败，类型提升
        System.out.println("b = " + b);
    }
}
