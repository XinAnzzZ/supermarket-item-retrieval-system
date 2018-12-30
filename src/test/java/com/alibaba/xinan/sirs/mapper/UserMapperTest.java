package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.User;
import com.alibaba.xinan.sirs.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author XinAnzzZ
 * @date 2018/12/29 23:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setId(CommonUtils.generateId());
        user.setUsername("test01");
        user.setPhoneNumber("test01");
        user.setPassword("12314141342");
        user.setEmail("ndoajundo");
        userMapper.insert(user);
    }

    @Test
    public void findById() {
        System.out.println(userMapper.findById("b24046545bb6499e8b8d4b952e0330a3"));
    }

    @Test
    public void findAll() {
        User user = new User();
        user.setPhoneNumber("12345678911");
        System.out.println(userMapper.findAll(user));
    }
}