package com.it.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author jw
 * @Date 2021/12/20 15:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItem {
    private List<String> interesting;
}
