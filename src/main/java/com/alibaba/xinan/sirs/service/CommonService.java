package com.alibaba.xinan.sirs.service;

import com.alibaba.xinan.sirs.entity.Account;
import com.alibaba.xinan.sirs.entity.form.ProductAddForm;
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

    /**
     * 获取商品类目列表
     *
     * @return 类目列表
     */
    ResponseVO getProductCategoryList();

    /**
     * 添加商品
     *
     * @param form data form
     * @return result
     */
    ResponseVO addProduct(ProductAddForm form);

    /**
     * delete product
     *
     * @param productId product id
     * @return resp
     */
    ResponseVO deleteProduct(String productId);

    /**
     * 更新商品
     *
     * @param productAddForm product
     * @return result
     */
    ResponseVO editProduct(ProductAddForm productAddForm);

    /**
     * account list
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @return list
     */
    ResponseVO getAccountList(Integer pageNum, Integer pageSize);

    /**
     * 冻结账户
     *
     * @param id id
     * @return result
     */
    ResponseVO freezeAccount(Integer id);

    /**
     * edit account
     *
     * @param account the account
     * @return result
     */
    ResponseVO editAccount(Account account);

    /**
     * add account
     *
     * @param account the account
     * @return reslut
     */
    ResponseVO addAccount(Account account);
}
