package com.baizhi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by wdwhwn on 2018/11/25.
 */
@Document(collection="employee")
public class Employee implements Serializable{

    @Id // 标示主键
    private String id;

    private String name;

    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @PersistenceConstructor // 使用有参的构造方法 保存文档信息
    public Employee(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }
}
