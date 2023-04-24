package com.mume.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DruidUtils 连接池
 * @author mume
 */
public class DruidUtils {
    // 1.定义成员变量
    public static DataSource dataSource;

    // 2.静态代码块
    static {
        try {
            // 3.创建属性对象
            Properties p = new Properties();

            // 4.Druid连接池不能主动加载配置文件，需要指定文件
            InputStream resourceAsStream = DruidDataSourceFactory.class.getClassLoader().getResourceAsStream("druid.properties");

            // 5.Properties对象的load方法 从字节流中读取配置信息
            p.load(resourceAsStream);

            // 6.通过工厂类获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 获取连接的方法
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
