package com.finance.suggestion;

import com.finance.util.FileUtil;
import com.finance.util.SedisUtil;
import com.finance.util.TimeUtil;
import redis.clients.jedis.Jedis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianle.li on 2016/7/21.
 */
public class HandleRedis {
    private static final String Separator = "\t";
    private static Jedis jedis = SedisUtil.jedis;
    private static Map<String, String> codeMap = new HashMap<String, String>();
    private static Set<String> codeSet = new HashSet<String>();
    private static String stockCode = null;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = FileUtil.createWriteBw("test");
        for (String key : jedis.keys("history_*")) {
            handleToSet(key, jedis.get(key));
        }
        handleHistory(bw);
        jedis.close();
        bw.close();
    }

    private static void handleToSet(String key, String value) {
        String[] arr = key.split("_");
        String date = arr[1];
        String code = arr[2];
        if (stockCode == null) {
            stockCode = code;
        }
        codeMap.put(date + Separator + code, value);
        codeSet.add(date + Separator + code + Separator + value);
    }


    private static void handleHistory(BufferedWriter bw) throws IOException {
        String today = TimeUtil.getTodayStr("yyyy-MM-dd");
        boolean isEnd = false;
        int count = 0, total = 0;
        while (!isEnd) {
            String[] dateArr = today.split("-");
            int year = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int day = Integer.parseInt(dateArr[2]);
            String preToday = TimeUtil.getNowOfLastYear(year, month, day, "yyyy-MM-dd");
            if (codeMap.containsKey(preToday + Separator + stockCode)) {
                String value = codeMap.get(preToday + Separator + stockCode);
                int valueInt = Integer.parseInt(value);
                count++;
                total += valueInt;
                bw.write(stockCode + Separator + preToday + Separator + total / count);
            } else {
                isEnd = true;
            }

        }

    }
}
