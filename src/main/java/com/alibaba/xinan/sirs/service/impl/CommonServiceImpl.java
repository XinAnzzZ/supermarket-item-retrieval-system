package com.alibaba.xinan.sirs.service.impl;

import com.alibaba.xinan.sirs.entity.form.UserRegisterForm;
import com.alibaba.xinan.sirs.entity.vo.ResponseVO;
import com.alibaba.xinan.sirs.mapper.UserMapper;
import com.alibaba.xinan.sirs.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XinAnzzZ
 * @date 2018/11/22 15:50
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVO register(UserRegisterForm form) {

        return null;
    }
}
