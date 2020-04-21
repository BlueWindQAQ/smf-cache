package com.smf.demo.cache.service;

import com.smf.demo.cache.utils.ConstantsUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Title :
 * @Author : joseph.lv
 * @Date : 2020/4/20
 */
@CacheConfig(cacheNames = "myCache")
@Service
public class CacheService {

    @Cacheable(key="#p0")//#：取值方式    p:参数的意思parameter     0：下标
    public String  test1(Integer id) {
        System.out.println(id+"非1");
        return id.toString();
    }

    @CachePut(value =ConstantsUtil.CACHE_30S,key = "#id" )
    public String  update(Integer id) {
        Long result = id + System.currentTimeMillis();
        System.out.println("update"+result);
        return result.toString();
    }
    @CacheEvict(value =ConstantsUtil.CACHE_30S,key = "#id")
    public void delete(Integer id) {
        System.out.println("删除"+id);
    }
    @Cacheable(value = ConstantsUtil.CACHE_30S,key = "#id" )
    public String query(Integer id) {
        System.out.println(id+"test4");
        return id.toString();
    }

    public String  test5(Integer id) {
        System.out.println(id+"test5");
        return id.toString();
    }
}
