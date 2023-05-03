package com.mume.Module01_jdbc.testDBUtils;

import com.mume.Module01_jdbc.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mume
 */
public class DBUtilsDemo {

    // QueryRunner 核心类的创建方式
    public static void main(String[] args) {
        // 方式1 手动模式
        QueryRunner qr = new QueryRunner();

        // 方法2 自动模式 提供数据库连接池对象 DBUtils会自动维护连接
        QueryRunner qr2 = new QueryRunner(DruidUtils.getDataSource());
    }

    @Test
    public void testInsert() throws SQLException {
        // 1.创建QueryRunner 手动模式创建
        QueryRunner qr = new QueryRunner();

        // 2.编写占位符方式 SQL
        String sql = "insert into employees value(?,?,?,?,?,?)";

        // 3.设置占位符的参数
        Object[] param = {null,"rushB","oo","rushB@gamil.com","1345-04-23",24535};

        // 4.执行update方法
        Connection con = DruidUtils.getConnection();
        int i = qr.update(con, sql, param);

        // 5.释放资源
//        con.close();
        DbUtils.close(con);
    }

    @Test
    public void testUpdate() throws SQLException {
        //1.创建核心类 自动模式 需要传递数据库连接对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        //2.编写sql
        String sql = "update employees set salary = ? where first_name = ?";

        // 3.设置占位符的参数
        Object[] param = {43567, "rushB"};

        // 4.执行update方法
        int i = qr.update(sql, param);
    }

    @Test
    public void testDelete() throws SQLException {
        //1.创建核心类 自动模式 需要传递数据库连接对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        //2.编写sql
        String sql = "delete from employees where id = ?";

        // 如果只有一个参数的话，不需要创建数组
        int i = qr.update(sql, 1);
    }
}
