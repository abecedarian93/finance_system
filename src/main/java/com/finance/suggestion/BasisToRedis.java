package com.finance.suggestion;

import com.finance.util.DbUtil;
import com.finance.util.SedisUtil;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tianle.li on 2016/7/21.
 */
public class BasisToRedis {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = DbUtil.getLocalConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from stock_basics");
        Jedis jedis = SedisUtil.jedis;
        while (rs.next()) {
            String code = rs.getString(1);
            String name = rs.getString(2);
            String industry = rs.getString(3);
            String area = rs.getString(4);
            jedis.set("code=" + code, name + "_" + industry + "_" + area);
            System.out.println(code + "\t" + name + "_" + industry + "_" + area);
        }
        jedis.close();
        conn.close();
    }

}
