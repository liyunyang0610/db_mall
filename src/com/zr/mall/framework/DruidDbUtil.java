package com.zr.mall.framework;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDbUtil {


    public static Connection getConnection() {
        Connection connection=null;
        try {
            DataSource ds = getDataSource();
            System.out.println(ds);
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void colse(Connection connection) {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static DataSource getDataSource() {
        DruidDataSource ds = null;
        try {
            InputStream inputStream = DruidDbUtil.class.getClassLoader().getResourceAsStream("db.properties");
           //InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
            Properties properties= new Properties();
            properties.load(inputStream);
            ds = new DruidDataSource();
            ds.configFromPropety(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ds;
    }


    /**
     * 通过代码方式进行获取连接池
     */
    private static void getCon() {
        String driverClassName="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql:///db_mall?serverTimezone=UTC";
        String username="root";
        String password="19920610";

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
