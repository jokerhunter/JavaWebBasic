package com.mume.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {

    // 1. 创建连接池对象 C3P0对DataSource接口的实现类
    // 使用的是配置文件中的默认配置
//    public static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 使用指定的配置
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    // 获取连接的方法
    public static Connection getConnection() throws SQLException {
        // 从连接池获取连接
        Connection connection = dataSource.getConnection();
        return connection;
    }

    // 5.释放资源方法
    public static void close(Connection con, Statement statement) {
        if (null != con && null != statement) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

}
