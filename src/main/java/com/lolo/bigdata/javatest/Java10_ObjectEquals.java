package com.lolo.bigdata.javatest;

/**
 * @Author: gordon  Email:gordon_ml@163.com
 * @Date: 11/13/2019
 * @Description:
 * @version: 1.0
 */
public class Java10_ObjectEquals {

    public static void main(String[] args) {

        User10 user1 = new User10();
        User10 user2 = new User10();
        System.out.println(user1.equals(null));
    }
}

class User10 {

    private int id;
    private String name;

    /**
     * 重写hashCode是在类似HashMap结构时候才有用
     * HashMap要先保证hashCode值相同才有意义
     */
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof User10) {
            User10 otherUser = (User10) obj;
            return this.id == otherUser.id;
        } else {
            return false;
        }
    }
}
