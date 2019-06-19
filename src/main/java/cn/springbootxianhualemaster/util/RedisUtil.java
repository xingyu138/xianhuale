package cn.springbootxianhualemaster.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,String> template;


    public void set(String key, String value) {
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key,value);
    }


    public void set(String key, String value, int timeout) {
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key,value,timeout, TimeUnit.SECONDS);
    }


    public String get(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        return operations.get(key);
    }


    public void del(String key) {
        template.delete(key);
    }


    public Long incr(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        Long increment = operations.increment(key,1);
        return increment;
    }


    public Long decr(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        Long increment = operations.increment(key,-1);
        return increment;
    }


    public void setExp(String key, int seconds) {
        template.expire(key,seconds,TimeUnit.SECONDS);
    }


    public Long getExp(String key) {
        Long expire = template.getExpire(key);
        return expire;
    }


    public void lpush(String key, Object value) {
        ListOperations list = template.opsForList();
        list.leftPush(key,value);
    }


    public Object rpop(String key) {
        ListOperations opsForList = template.opsForList();
        return opsForList.rightPop(key);
    }


    public void hset(String key, String item, String value) {
        HashOperations<String, Object, Object> opsForHash = template.opsForHash();
        opsForHash.put(key,item,value);
    }


    public String hget(String key, String item) {
        HashOperations opsForHash = template.opsForHash();
        return (String) opsForHash.get(key,item);
    }

    public void hdel(String key, String item) {
        HashOperations opsForHash = template.opsForHash();
        opsForHash.delete(key,item);
    }


}
