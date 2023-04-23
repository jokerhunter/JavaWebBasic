package com.mume.testPool;

import com.mume.utils.DBCPUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPTest {

    /**
     * 测试DBCP连接池
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        // 1.从DBCP连接池拿到连接
        Connection connection = DBCPUtils.getConnection();

        // 2.获取statement对象
        Statement statement = connection.createStatement();

        // 3. 查询
        String sql = "select first_name from employees";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4.处理结果集
        while(resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            System.out.println("员工名字" + firstName);
        }

        DBCPUtils.close(connection, statement);
    }
}
