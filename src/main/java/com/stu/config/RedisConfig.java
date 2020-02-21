package com.stu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName：RedisConfig
 * Description：封装原始 RedisTemplate 缓存类
 *
 * @author lihw
 * CreateTime: 2019/12/12 17:23
 * @version 1.0.0
 */
@Component
public class RedisConfig {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * MethodName: 读取缓存
     * Description:
     * @author lhw
     * CreateTime 2019/12/12 17:56
     * @param
     * @return
     */

    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

   /**
    * MethodName: 写入缓存
    * Description:
    * @author lhw
    * CreateTime 2019/12/12 17:56
    * @param
    * @return
    */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * MethodName: 更新缓存
     * Description:
     * @author lhw
     * CreateTime 2019/12/12 17:56
     * @param
     * @return
     */
    public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * MethodName: 删除缓存
     * Description:
     * @author lhw
     * CreateTime 2019/12/12 17:57
     * @param
     * @return
     */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

   /**
    * MethodName: 指定时间缓存失效
    * Description:
    * @author lhw
    * CreateTime 2019/12/12 17:57
    * @param key
    * @param time (时间为：秒)
    * @return
    */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   /**
    * MethodName: 判断key是否存在
    * Description:
    * @author lhw
    * CreateTime 2019/12/12 22:29
    * @param
    * @return
    */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
