package com.it.demo.feign;

import com.it.demo.model.UserItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author jw
 * @Date 2021/12/20 15:21
 */
@FeignClient(name = "USER-ITEM-SERVICE")
@RequestMapping("/item")
public interface UserItemFeign {

    @GetMapping("/getUserItem")
    UserItem getUserItem(@RequestParam(name = "id") Integer id);
}
