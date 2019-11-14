package com.lolo.bigdata.javatest;

/**
 * @Author: gordon  Email:gordon_ml@163.com
 * @Date: 11/14/2019
 * @Description: 泛型2 : 类树，父类的范围大
 * @version: 1.0
 */
public class Java12_Generic2 {

    public static void main(String[] args) {

        //test(Animal.class);
        test(Person12.class);
        test(User12.class);
        //test(Student12.class);

        test1(Animal.class);
        test1(Person12.class);
        //test1(User12.class);
        //test(Student12.class);
    }

    // 添加泛型，继承Person12的类可以传递参数，extends体现类的体系树的上限
    private static void test(Class<? extends Person12> c) {
        System.out.println(c);
    }

    // 添加泛型，父类型是Person12的类可以传递参数，extends体现类的体系树的下限
    private static void test1(Class<? super Person12> c) {
        System.out.println(c);
    }

}

class Animal {

}

class Person12 extends Animal {

}

class User12 extends Person12 {

}

class Student12 {

}
