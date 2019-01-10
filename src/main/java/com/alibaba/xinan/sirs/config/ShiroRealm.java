package com.alibaba.xinan.sirs.config;

import com.alibaba.xinan.sirs.entity.User;
import com.alibaba.xinan.sirs.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author XinAnzzZ
 * @date 2018/8/15 10:14
 */
@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取认证信息
     *
     * @param token token  就是登陆时候带过来的认证信息，如果认证通过，这些信息会被shiro缓存
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userMapper.getByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        // 加盐，使用用户名作为盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        String realmName = getName();
        return new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, realmName);
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
