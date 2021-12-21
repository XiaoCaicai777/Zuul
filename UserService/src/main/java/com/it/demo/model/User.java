package com.it.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jw
 * @Date 2021/12/20 14:52
 */
@Data
@NoArgsConstructor
public class User {
    private String name;
    private String gender;
    private Integer age;
    private UserItem userItem;
    public User(String name,String gender,Integer age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
