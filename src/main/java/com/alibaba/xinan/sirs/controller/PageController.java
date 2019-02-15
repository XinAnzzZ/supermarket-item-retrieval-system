package com.alibaba.xinan.sirs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author XinAnzzZ
 * @date 2018/11/21 10:45
 */
@Controller
public class PageController {

    @GetMapping(value = {"/", "/index"})
    public String login() {
        return "index";
    }

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }
}
