package com.finance.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tianle.li on 2016/7/28.
 */
public class FileUtil {

    public static String filePath() {

        if (File.separator.equals("/")) {
            return "";
        } else {
            return "D:\\dev\\finance_system";
        }
    }

    public static BufferedWriter createWriteBw(String fileName) {
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
}
