package com.alibaba.xinan.sirs.util;

import lombok.Data;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author XinAnzzZ
 * @date 2018/8/15 10:20
 */
@Component
@ConfigurationProperties(prefix = "shiro")
@Data
public class ShiroUtils {

    private String hashAlgorithmName;

    private Integer hashIterations;

    /**
     * shiro 的MD5加密，通过用户的密码和用户名作为盐进行1024次加密
     *
     * @param credentials 凭证（密码）
     * @param salt        盐（用户名）
     * @return 加密后的结果
     */
    public String toMD5(String credentials, String salt) {
        return new SimpleHash(hashAlgorithmName, credentials, ByteSource.Util.bytes(salt), hashIterations).toString();
    }
}
