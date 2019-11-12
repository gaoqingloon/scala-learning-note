package com.lolo.bigdata.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gordon  Email:gordon_ml@163.com
 * @Date: 11/12/2019
 * @Description: Java访问权限
 * @version: 1.0
 */
public class Java07_Access {

    public static void main(String[] args) throws Exception {

        /*
        ArrayList<String> list = new ArrayList<>();
        list.clone();

        List<String> list1 = new ArrayList<>();
        list1.clone();
        */

        /*
        访问权限
            同类、同包，父子关系
            所谓的权限其实是方法的提供者和方法的调用者之间的关系
            方法的提供者：java.lang.Object
            方法的调用者：com.lolo.bigdata.javatest.Java07_Access
            . 表示的是从属关系，是谁的

            方法的提供者：com.lolo.bigdata.javatest.A
            方法的调用者：com.lolo.bigdata.javatest.Java07_Access
        */
        /*
        在main方法中构建了一个对象A，然后调用了A当中的clone()方法
         */
        A a = new A();
        a.clone();

        User user = new User();
        user.username = "tom";

    }

    public static void test(List list) {

    }
}

class A {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class User {
    public String username;
}
