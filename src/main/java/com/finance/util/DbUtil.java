package com.finance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tianle.li on 2016/7/21.
 * 用于连接MySQL
 */
public class DbUtil {

    public static Statement stat = null;

    public static Connection getLocalConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance_system", "root", "115422");

        return conn;
    }

}
