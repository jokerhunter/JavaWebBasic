package com.mume.Module01_jdbc.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPUtils {
    // 1.定义常量 保存数据库连接的相关信息
    public static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://1.15.186.206:13306/JavaWebBasic?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "tqooteMysql0028";

    // 2.创建连接池对象（有DBCP提供的实现类）
    public static BasicDataSource dataSource = new BasicDataSource();

    // 3. 使用静态代码块进行配置
    static {
        dataSource.setDriverClassName(DRIVERNAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    // 4. 获取连接的方法
    public static Connection getConnection() throws SQLException {
        // 从连接池中获取连接
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

    public static void close(Connection con, Statement statement, ResultSet resultSet) {
        if (null != con && null != statement && null != resultSet) {
            try {
                resultSet.close();
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

}
