package com.mume.Module01_jdbc.testDBUtils;

import com.mume.Module01_jdbc.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author mume
 */
public class DBUtilsBatchDemo {
    // 使用批处理 像表中添加 10000 条数据
    public static void main(String[] args) throws SQLException {
        // 1.获取连接
        Connection connection = DruidUtils.getConnection();

        // 2.获取预处理对象
        PreparedStatement ps = connection.prepareStatement("insert into testBatch(uname) values (?)");

        // 3.执行批量插入操作
        for (int i = 0; i < 10000; i++) {
            ps.setString(1, "aaa" + i);
            // 将SQL添加到批处理列表
            ps.addBatch();
        }

        // 4.统一执行 批量插入操作
        ps.executeBatch();

        // 5.关闭连接
        DruidUtils.close(connection, ps);
    }
}
