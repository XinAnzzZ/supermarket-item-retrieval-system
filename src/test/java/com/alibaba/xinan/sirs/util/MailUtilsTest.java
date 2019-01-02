package com.alibaba.xinan.sirs.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailUtilsTest {

    @Autowired
    private MailUtils mailUtils;

    @Test
    public void fun() {

    }

    @Test
    public void send() {
        mailUtils.sendSimpleMail("1150989249@qq.com", "test", "test");
    }
}