package com.stu.domain;

import java.io.Serializable;

/**
 * ClassName：Users
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/15 12:33
 * @version 1.0.0
 */
public class User implements Serializable {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
