package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinjunan
 * @date 2019/6/29 19:08
 * @version V1.0
 */

@Controller
@RestController
public class TestController {

    @RequestMapping("testController")
    public String testController(){
        System.out.println("---------------测试controller方法--------------");
        return "hello world";
    }
}
