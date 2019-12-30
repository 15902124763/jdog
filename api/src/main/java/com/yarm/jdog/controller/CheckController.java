package com.yarm.jdog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jdog
 * @description: 健康监测
 * @author: yarm.yang
 * @create: 2019-12-30 12:55
 */
@RestController
@RequestMapping("/")
public class CheckController {
    @RequestMapping
    public String check(){
        return "server action";
    }
}
