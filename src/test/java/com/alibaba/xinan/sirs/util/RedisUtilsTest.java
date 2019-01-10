package com.alibaba.xinan.sirs.util;

import org.apache.shiro.session.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SerializationUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test

    public void fun() {

    }

    @Test
    public void get() {
        byte[] sessionValue = redisUtils.get("sirs-session:27410c6a-5b39-486e-95ec-eec26fdc1a21".getBytes());
        Session session = (Session) SerializationUtils.deserialize(sessionValue);
        System.out.println(session);
    }
}