package com.web.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPageController {

    @GetMapping("/page/user/addition")
    public String addUser() {
        return "AddUser";
    }

    @GetMapping("/page/user/search")
    public String searchUser() {
        return "FindUser";
    }

    @GetMapping("/page/users")
    public String users() {
        return "UserList";
    }


}
