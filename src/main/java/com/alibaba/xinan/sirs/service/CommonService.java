package com.alibaba.xinan.sirs.service;

import com.alibaba.xinan.sirs.entity.form.ProductQueryForm;
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

    /**
     * send valid code email
     *
     * @param username the username
     * @param email    email address
     * @return result
     */
    ResponseVO sendValidCodeEmail(String username, String email);

    /**
     * 获取商品列表
     *
     * @param form 查询条件封装对象
     * @return 商品列表
     */
    ResponseVO getProductList(ProductQueryForm form);
}
