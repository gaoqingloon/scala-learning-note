package com.lolo.bigdata.javatest;

import com.lolo.bigdata.scala.chapter060708.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gordon  Email:gordon_ml@163.com
 * @Date: 11/14/2019
 * @Description: 泛型1
 * @version: 1.0
 */
public class Java11_Generic {

    public static void main(String[] args) {

        // 1. 所谓的泛型就是对类型的约束
        //ArrayList<String> list = new ArrayList<>();


        // 2. java中的泛型具有不变性
        List<Person11> user = new ArrayList<>();
        user.add(new User11());  // User11 ==> Person16 有关联


        // 3. java中泛型的作用范围，只能对其后面的代码起约束，不能约束添加泛型之前的代码
        List list = new ArrayList();
        list.add(new Student());

        List<Person11> personList = list; //此处加泛型，只能对其后面的代码起约束
        // 此处读取不需要考虑类型
        System.out.println(personList);//[com.lolo.bigdata.javatest.Student@5cad8086]
        // 此处读取需要考虑类型，错误 xxx.Student cannot be cast to xxx.Person11
        for (Person11 person11 : personList) {
            System.out.println(person11);
        }
    }
}

class Person11 {

}

class User11 extends Person11 {

}

class Student {

}
