package com.it.demo.controller;

import com.it.demo.model.UserItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author jw
 * @Date 2021/12/20 15:10
 */
@RestController
@Slf4j
@RequestMapping("/item")
public class UserItemController {
    public static final List<UserItem> list = new ArrayList();

    static {
        list.add(new UserItem(new ArrayList<String>(Arrays.asList(new String[]{"足球","排球"}))));
        list.add(new UserItem(new ArrayList<String>(Arrays.asList(new String[]{"足球","篮球"}))));
        list.add(new UserItem(new ArrayList<String>(Arrays.asList(new String[]{"乒乓球","排球"}))));
        list.add(new UserItem(new ArrayList<String>(Arrays.asList(new String[]{"桌球","排球"}))));
        list.add(new UserItem(new ArrayList<String>(Arrays.asList(new String[]{"铅球","排球"}))));
    }

    @GetMapping("/getUserItem")
    public UserItem getUserItem(Integer id){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list.get(id);
    }

}
