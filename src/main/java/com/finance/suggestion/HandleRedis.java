package com.finance.suggestion;

import com.finance.util.SedisUtil;
import redis.clients.jedis.Jedis;

/**
 * Created by tianle.li on 2016/7/21.
 */
public class HandleRedis {
    private static Jedis jedis = SedisUtil.jedis;

    public static void main(String[] args) {
        for (String key : jedis.keys("history_*")) {

            System.out.println(key + "\t" + jedis.get(key));
            HandleStock.handleHistory(key, jedis.get(key));
        }

        jedis.close();
    }
}
