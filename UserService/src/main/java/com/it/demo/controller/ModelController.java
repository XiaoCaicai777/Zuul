package com.it.demo.controller;

import com.it.demo.feign.UserItemFeign;
import com.it.demo.model.User;
import com.it.demo.model.UserItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jw
 * @Date 2021/12/20 14:49
 */
@RestController
@RequestMapping("/user")
public class ModelController {

    @Autowired
    private UserItemFeign feign;

    public static final List<User> map = new ArrayList();
    static{
        map.add(new User("小红","女",16)       );
        map.add(new User("小兰","男",66)       );
        map.add(new User("小绿","女",26)       );
        map.add(new User("小紫","男",13)       );
        map.add(new User("小白","女",17)       );
    }

    @GetMapping("/getUser")
    public User getUser(Integer id){
        try {
            return map.get(id);
        } catch (Exception e) {
            return new User();
        }
    }

    @GetMapping("/getUserDetails")
    public User getUserDetails(Integer id){
        try {
            UserItem userItem = feign.getUserItem(id);
            User user = map.get(id);
            user.setUserItem(userItem);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new User();
        }
    }
}
