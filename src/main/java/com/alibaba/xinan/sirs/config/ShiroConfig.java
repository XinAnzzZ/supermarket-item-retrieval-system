package com.alibaba.xinan.sirs.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author XinAnzzZ
 * @date 2019/1/9 16:38
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/common/unauthorized");

        // 路由规则
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>(16);
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setCacheManager(redisCacheManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * 自定义realm
     *
     * @return realm
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    /**
     * redis 缓存管理器
     *
     * @return redis 缓存管理器
     */
    private RedisCacheManager redisCacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    private RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("47.106.198.5");
        redisManager.setPort(6379);
        redisManager.setExpire(1800);
        redisManager.setTimeout(0);
        return redisManager;
    }

    /**
     * session管理器
     *
     * @return session 管理器
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }

    /**
     * session dao
     *
     * @return session dao
     */
    @Bean
    public RedisSessionDAO sessionDAO() {
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setRedisManager(redisManager());
        return sessionDAO;
    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 注解
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
