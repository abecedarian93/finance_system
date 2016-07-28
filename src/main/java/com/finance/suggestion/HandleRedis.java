package com.finance.suggestion;

import com.finance.util.FileUtil;
import com.finance.util.SedisUtil;
import redis.clients.jedis.Jedis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tianle.li on 2016/7/21.
 */
public class HandleRedis {
    private final static String Separator = "\t";
    private static Jedis jedis = SedisUtil.jedis;

    public HandleRedis() {

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = createWriteBw("test");
        for (String key : jedis.keys("history_*")) {
            System.out.println(key + "\t" + jedis.get(key));
            handleHistory(key, jedis.get(key), bw);
        }
        jedis.close();
        bw.close();
    }

    private static BufferedWriter createWriteBw(String fileName) {
        String filePath = FileUtil.filePath() + File.separator + fileName + ".txt";
        BufferedWriter bw = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                file.setExecutable(true, false);
                file.setReadable(true, false);
                file.setWritable(true, false);
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bw;
    }

    private static void handleHistory(String key, String value, BufferedWriter bw) throws IOException {
        String[] arr = key.split("_");
        String date = arr[1];
        String code = arr[2];
        bw.write(date + Separator + code + Separator + value);
        bw.newLine();
    }
}
