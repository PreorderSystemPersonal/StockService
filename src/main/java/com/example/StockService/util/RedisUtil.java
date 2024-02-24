package com.example.StockService.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisUtil {

    private final RedisTemplate<Long, Long> redisTemplate;

    public RedisUtil(RedisTemplate<Long, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long getData(Long key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setData(Long key, Long value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setDataExpire(Long key, Long value, long duration) {
        Duration expireDuration = Duration.ofSeconds(duration);
        redisTemplate.opsForValue().set(key, value, expireDuration);
    }

    public void deleteData(Long key) {
        redisTemplate.delete(key);
    }

    public boolean hasKey(Long key) {
        return redisTemplate.hasKey(key);
    }
}
