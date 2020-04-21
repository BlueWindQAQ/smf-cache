package com.smf.demo.cache.controller;

import com.smf.demo.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title :
 * @Author : joseph.lv
 * @Date : 2020/4/20
 */
@RestController
@RequestMapping("/cacheTest")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() {
        System.out.println("test1----" + cacheService.test1(200));
        Integer id = 1000;
        System.out.println("query----" + cacheService.query(id));
        System.out.println("update----" + cacheService.update(id));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        cacheService.delete(id);
        return "ok";
    }

}
