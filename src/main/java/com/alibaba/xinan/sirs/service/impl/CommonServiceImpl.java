package com.alibaba.xinan.sirs.service.impl;

import com.alibaba.xinan.sirs.entity.Product;
import com.alibaba.xinan.sirs.entity.User;
import com.alibaba.xinan.sirs.entity.form.ProductQueryForm;
import com.alibaba.xinan.sirs.entity.form.UserRegisterForm;
import com.alibaba.xinan.sirs.entity.query.ProductQuery;
import com.alibaba.xinan.sirs.entity.vo.ResponseVO;
import com.alibaba.xinan.sirs.mapper.ProductCategoryMapper;
import com.alibaba.xinan.sirs.mapper.ProductMapper;
import com.alibaba.xinan.sirs.mapper.UserMapper;
import com.alibaba.xinan.sirs.service.CommonService;
import com.alibaba.xinan.sirs.util.MailUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/11/22 15:50
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public ResponseVO register(UserRegisterForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeat())) {
            return ResponseVO.fail("两次输入的密码不一致！");
        }
        // 验证手机号唯一性
        User user = new User();
        user.setPhoneNumber(form.getPhoneNumber());
        List<User> list = userMapper.findAll(user);
        if (CollectionUtils.isEmpty(list)) {
            return ResponseVO.fail("手机号已存在！");
        }

        // 验证邮箱唯一性
        user.setPhoneNumber(null);
        user.setEmail(form.getEmail());
        list = userMapper.findAll(user);
        if (CollectionUtils.isEmpty(list)) {
            return ResponseVO.fail("邮箱已存在！");
        }

        // 验证用户名唯一性
        user.setEmail(null);
        user.setUsername(form.getUsername());
        list = userMapper.findAll(user);
        if (CollectionUtils.isEmpty(list)) {
            return ResponseVO.fail("用户名已存在！");
        }

        user = new User();
        BeanUtils.copyProperties(form, user);
        userMapper.insert(user);
        return ResponseVO.success();
    }

    @Override
    public ResponseVO sendValidCodeEmail(String username, String email) {
        Context context = new Context();
        context.setVariable("username", username);
        context.setVariable("code", email);
        final String registerMailTemplateName = "mailTemplates/registerMailTemplate";
        final String subject = "注册验证邮件";
        String process = templateEngine.process(registerMailTemplateName, context);
        mailUtils.sendHtmlMail(email, subject, process);
        return ResponseVO.success();
    }

    @Override
    public ResponseVO getProductList(ProductQueryForm form) {
        ProductQuery query = ProductQuery.builder().build();

        BeanUtils.copyProperties(form, query);
        PageInfo<Product> pageInfo = PageHelper
                .startPage(form.getPageNum(), form.getPageSize())
                .doSelectPageInfo(() -> productMapper.listAll(query));

        return ResponseVO.success(pageInfo);
    }

    @Override
    public ResponseVO getProductCategoryList() {
        return ResponseVO.success(productCategoryMapper.listAllCategory());
    }
}
