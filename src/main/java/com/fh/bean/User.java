package com.fh.bean;

import com.fh.poi.UserAnnotation;


@UserAnnotation(tableName = "t_user")
public class User {
    @UserAnnotation(name = "t_id")
    private int id;
    @UserAnnotation(name="t_name")
    private String name;
    @UserAnnotation(name="t_age")
    private Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
