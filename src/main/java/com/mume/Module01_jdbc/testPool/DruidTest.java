package com.mume.Module01_jdbc.testPool;

import com.mume.Module01_jdbc.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidTest {
    // 获取查询薪资在3000到5000的员工姓名
    public static void main(String[] args) throws SQLException {
        // 1.获取连接
        Connection con = DruidUtils.getConnection();

        // 2.获取Statement对象
        Statement statement = con.createStatement();
        String sql = "select * from employees where salary between 3000 and 60000;";

        // 3.执行查询
        ResultSet resultSet = statement.executeQuery(sql);

        // 4.处理结果集
        while(resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            System.out.println("firstName:" + firstName);
        }

        DruidUtils.close(con, statement);
    }
}
