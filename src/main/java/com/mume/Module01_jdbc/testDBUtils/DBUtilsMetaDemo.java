package com.mume.Module01_jdbc.testDBUtils;

import com.mume.Module01_jdbc.utils.DruidUtils;
import org.junit.jupiter.api.Test;


import java.sql.*;

/**
 * @author mume
 */
public class DBUtilsMetaDemo {

    /**
     * 1.获取数据库相关的元数据信息 使用DatabaseMetaData
     * @throws SQLException
     */
    @Test
    public void testDataBaseMetaData() throws SQLException {

        // 1.获取数据库连接对象 connection
        Connection connection = DruidUtils.getConnection();

        // 2.获取代表数据库的元数据对象
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        // 3.获取数据库相关的元数据信息
        String url = databaseMetaData.getURL();
        System.out.println("数据库URL:" + url);

        String username = databaseMetaData.getUserName();
        System.out.println("username:" + username);

        String productName = databaseMetaData.getDatabaseProductName();
        System.out.println("prodductName:" + productName);

        String version = databaseMetaData.getDatabaseProductVersion();
        System.out.println("version:" + version);

        String driverName = databaseMetaData.getDriverName();
        System.out.println("driverName" + driverName);

        if (databaseMetaData.isReadOnly()) {
            System.out.println("this database is read only");
        } else {
            System.out.println("not read only");
        }
        connection.close();
    }

    @Test
    public void testResultSetMetaData() throws SQLException {
        // 1.获取连接
        Connection con = DruidUtils.getConnection();

        // 2.获取预处理对象
        PreparedStatement ps = con.prepareStatement("select * from employees");
        ResultSet resultSet = ps.executeQuery();

        // 3.获取结果集元数据对象
        ResultSetMetaData metaData = ps.getMetaData();

        // 1、获取当前结果集 共有多少列
        int count = metaData.getColumnCount();
        System.out.println("count resultset:" + count);

        // 2、获取结果集中对的列的名称和类型
        for (int i = 1; i <= count; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.println("first column name:" + columnName);

            String columnTypeName = metaData.getColumnTypeName(i);
            System.out.println("first column Type name:" + columnTypeName);
        }

        // 释放资源
        DruidUtils.close(con, ps);

    }
}
