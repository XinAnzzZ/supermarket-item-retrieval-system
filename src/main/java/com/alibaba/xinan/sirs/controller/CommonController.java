package com.alibaba.xinan.sirs.controller;

import com.alibaba.xinan.sirs.consts.DataBaseConst;
import com.alibaba.xinan.sirs.consts.RegexConst;
import com.alibaba.xinan.sirs.entity.User;
import com.alibaba.xinan.sirs.entity.form.ProductAddForm;
import com.alibaba.xinan.sirs.entity.form.ProductQueryForm;
import com.alibaba.xinan.sirs.entity.form.UserRegisterForm;
import com.alibaba.xinan.sirs.entity.vo.ResponseVO;
import com.alibaba.xinan.sirs.enums.ResponseEnum;
import com.alibaba.xinan.sirs.service.CommonService;
import com.alibaba.xinan.sirs.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XinAnzzZ
 * @date 2018/11/22 15:28
 */
@RestController
@Slf4j
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody User user) {
        log.info(user.toString());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！");
            return ResponseVO.fail(ResponseEnum.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e) {
            log.error("密码错误！");
            return ResponseVO.fail(ResponseEnum.INCORRECT_CREDENTIAL);
        } catch (Exception e) {
            log.error("未知错误！");
            e.printStackTrace();
            return ResponseVO.fail(ResponseEnum.LOGIN_FAILURE);
        }
        return ResponseVO.success();
    }

    /**
     * send email
     */
    @GetMapping("/send/valid/code/email")
    public ResponseVO sendValidCodeEmail(String username, String email) {
        if (StringUtils.isEmpty(username, email)) {
            return ResponseVO.fail(ResponseEnum.MISS_PARAM);
        }
        Pattern pattern = Pattern.compile(RegexConst.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return ResponseVO.fail("邮箱格式不正确！");
        }

        return commonService.sendValidCodeEmail(username, email);
    }

    /**
     * register
     */
    @PostMapping("/register")
    public ResponseVO register(@RequestBody @Valid UserRegisterForm form) {
        log.info("用户注册: {}" + form);
        return commonService.register(form);
    }

    /**
     * 商品列表
     */
    @GetMapping("/product/list")
    public ResponseVO getProductList(ProductQueryForm form) {
        if (form.getPageNum() == null || form.getPageNum() < DataBaseConst.DEFAULT_PAGE_NUM) {
            form.setPageNum(DataBaseConst.DEFAULT_PAGE_NUM);
        }
        if (form.getPageSize() == null
                || form.getPageSize() < DataBaseConst.MIN_PAGE_SIZE
                || form.getPageSize() > DataBaseConst.MAX_PAGE_SIZE) {
            form.setPageSize(DataBaseConst.DEFAULT_PAGE_SIZE);
        }
        return commonService.getProductList(form);
    }

    /**
     * 添加商品
     */
    @PostMapping("/add/product")
    public ResponseVO addProduct(@RequestBody @Valid ProductAddForm form, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseVO.fail(result.getAllErrors().toString());
        }
        return commonService.addProduct(form);
    }

    /**
     * 类目列表
     */
    @GetMapping("/category/list")
    public ResponseVO getProductCategoryList() {
        return commonService.getProductCategoryList();
    }
}
