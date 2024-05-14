package com.example.coding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liutc
 * @date 2023/12/21 13:44
 */
@RestController
public class TestController {

    @GetMapping("mvc")
    public String test() {
        return "MVC";
    }
}
