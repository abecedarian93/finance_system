package com.finance.suggestion;

import com.finance.util.SedisUtil;
import redis.clients.jedis.Jedis;

/**
 * Created by tianle.li on 2016/7/21.
 */
public class HandleRedis {
    private static Jedis jedis = SedisUtil.jedis;

    public static void main(String[] args) {
        for (String key : jedis.keys("code=*")) {
            String code = key.startsWith("code=") ? key.substring(5) : "";
            String value = jedis.get(key);
            HandleStock.handleCode(code);
            System.out.println(code);
        }


        jedis.close();
    }
}
