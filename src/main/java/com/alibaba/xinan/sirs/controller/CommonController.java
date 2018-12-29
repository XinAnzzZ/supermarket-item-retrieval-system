package com.alibaba.xinan.sirs.controller;

import com.alibaba.xinan.sirs.entity.User;
import com.alibaba.xinan.sirs.entity.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author XinAnzzZ
 * @date 2018/11/22 15:28
 */
@RestController
@Slf4j
public class CommonController {

    @PostMapping("/login")
    public ResponseVO login(@RequestBody User user) {
        log.info(user.toString());
        return ResponseVO.fail("fail");
    }

    @PostMapping("/register")
    public ResponseVO register(@RequestBody @Valid User user) {
        log.info("用户注册: {}" + user);
        return ResponseVO.success();
    }
}
