package com.finance.util;

import java.io.File;

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
}
