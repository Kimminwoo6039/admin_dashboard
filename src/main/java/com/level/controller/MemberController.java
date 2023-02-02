package com.level.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/joinForm")
    public String JoinForm() {
        return "join";
    }

    @RequestMapping("/login")
    public String LoginForm() {
        return "login";
    }

    @RequestMapping("/error1")
    public String error() {
        return error();
    }
}
