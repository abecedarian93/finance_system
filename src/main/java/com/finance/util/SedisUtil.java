package com.finance.util;

import redis.clients.jedis.Jedis;

/**
 * Created by tianle.li on 2016/7/21.
 * 用于连接Redis
 */
public class SedisUtil {

    public static Jedis jedis = null;

    static {
        try {
            jedis = new Jedis("114.215.92.231", 6379);
            jedis.auth("tiantian456");
        } catch (Exception e) {
            System.out.println("初始Sedis发生异常");
        }
    }


}
