package com.alibaba.xinan.sirs.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author XinAnzzZ
 * @date 2018/8/15 10:14
 */
@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {


    /**
     * 获取认证信息
     *
     * @param authenticationToken token  就是登陆时候带过来的认证信息，如果认证通过，这些信息会被shiro缓存
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        return null;
    }

    /**
     * 授权
     *
     * @param principalCollection 认证之后存在shiro中的用户信息
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
