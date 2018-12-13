package com.web.mvc.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class RedisUtils {
    private RedisTemplate<Serializable, Object> template;

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = template.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            System.out.println("set cache error" + e.getLocalizedMessage());
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = template.opsForValue();
            operations.set(key, value);
            template.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            System.out.println("set cache error" + e.getLocalizedMessage());
        }
        return result;
    }

    public Object get(String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = template.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            template.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return template.hasKey(key);
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.template = redisTemplate;
    }

}
