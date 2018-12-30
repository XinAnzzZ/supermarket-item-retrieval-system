package com.alibaba.xinan.sirs.service;

import com.alibaba.xinan.sirs.entity.form.UserRegisterForm;
import com.alibaba.xinan.sirs.entity.vo.ResponseVO;

/**
 * @author XinAnzzZ
 * @date 2018/11/22 15:50
 */
public interface CommonService {
    /**
     * user register
     *
     * @param form the register form
     * @return the result
     */
    ResponseVO register(UserRegisterForm form);
}
