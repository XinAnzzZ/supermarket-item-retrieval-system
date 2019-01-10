package com.alibaba.xinan.sirs.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author XinAnzzZ
 * @date 2019/1/10 16:01
 */
@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<byte[], byte[]> redisTemplate;

    /**
     * set key-value to redis
     *
     * @param key    the key
     * @param value  the value
     * @param expire the expire time TimeUnit.SECONDS
     */
    public void set(byte[] key, byte[] value, int expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * get value by key
     *
     * @param key the key
     * @return the value
     */
    public byte[] get(byte[] key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * delete by key
     *
     * @param key the key
     */
    public void deleteByKey(byte[] key) {
        redisTemplate.delete(key);
    }

    /**
     * get key set
     *
     * @param keyPrefix the key pattern
     * @return the key set
     */
    public Set<byte[]> keys(String keyPrefix) {
        return redisTemplate.keys((keyPrefix + "*").getBytes());
    }
}
