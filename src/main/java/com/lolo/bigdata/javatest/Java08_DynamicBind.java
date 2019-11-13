package com.lolo.bigdata.javatest;

/**
 * @Author: gordon  Email:gordon_ml@163.com
 * @Date: 11/12/2019
 * @Description: 动态绑定机制
 * @version: 1.0
 */
public class Java08_DynamicBind {

    public static void main(String[] args) {

        /*
        动态绑定机制
            成员方法在执行的过程中，JVM会将方法和当前调用对象实际内存进行绑定
            属性没有动态绑定机制，属性在哪里声明在哪里使用
         */
        AAA a = new BBB();
        System.out.println(a.getResult());  // 30
    }
}

class AAA {
    public int i = 10;
    public int getResult() {
        return getI() + 10;
    }
    public int getI() {
        return i;
    }
}

class BBB extends AAA {
    public int i = 20;
    /*public int getResult() {
        return getI() + 20;
    }*/
    public int getI() {
        return i;  // 其实是this.i
    }
}
