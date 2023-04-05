package com.web.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello(String name) {
        System.out.println(name);
        Map<String, String> testMap = new HashMap<>();
        testMap.put("name", name);
        testMap.put("age", "20");
        testMap.put("address", "Busan Dongragu Sajicdong");
        return testMap;
    }
}
