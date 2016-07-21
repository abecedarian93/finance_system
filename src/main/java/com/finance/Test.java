package com.finance;

import com.finance.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tianle.li on 2016/7/21.
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = DbUtil.getLocalConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from stock_basics");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        System.out.println("");


        conn.close();
    }
}
