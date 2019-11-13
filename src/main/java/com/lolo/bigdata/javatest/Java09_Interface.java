package com.lolo.bigdata.javatest;

/**
 * @Author: gordon  Email:gordon_ml@163.com
 * @Date: 11/12/2019
 * @Description:
 * @version: 1.0
 */
public class Java09_Interface {

    public static void main(String[] args) {

        // 多态传递 C09没有实现接口A09
        A09 a = new C09();
        System.out.println(C09.class.getInterfaces().length);  //0
    }
}

interface A09 {

}

class B09 implements A09 {

}

class C09 extends B09 {

}
