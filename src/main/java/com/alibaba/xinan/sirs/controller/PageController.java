package com.alibaba.xinan.sirs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author XinAnzzZ
 * @date 2018/11/21 10:45
 */
@Controller
public class PageController {

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("username", "test");
        model.addAttribute("code", "123");
        return "mailTemplates/registerMailTemplate";
    }
}
