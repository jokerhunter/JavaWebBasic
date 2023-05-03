package com.mume.Module01_jdbc.testDBUtils;

import com.mume.Module01_jdbc.entity.Employee;
import com.mume.Module01_jdbc.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author mume
 */
public class DBUtilsHandleDemo {

    /**
     * 查询id为5的记录，封装到数组中
     * ArrayHandler 将结果集的第一条数据封装到数字组中
     */
    @Test
    public void testFindById() throws SQLException {
        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写SQL
        String sql = "select * from employees where id = ?";

        // 3.执行查询
        Object[] query = qr.query(sql, new ArrayHandler(), 3);

        // 4.获取数据
        System.out.println(Arrays.toString(query));

    }

    /**
     * 查询所有数据，封装到List集合中
     * ArrayListHandler可以将每条数据封装到数组中，再将数组封装到集合中
     */
    @Test
    public void testQueryList() throws SQLException {
        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写SQL
        String sql = "select * from employees";

        // 3.执行查询
        List<Object[]> query = qr.query(sql, new ArrayListHandler());

        // 4.获取数据
        for (Object[] objects : query) {
            System.out.println(Arrays.toString(objects));
        }
    }

    /**
     * 查询所有数据，封装到JavaBean集合中
     * BeanHandler 将结果集的第一条数据封装到javaBean中
     *
     */
    @Test
    public void testFindByIdJavaBean() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写SQL
        String sql = "select * from employees where id = ?";

        // 3.执行查询
        Employee employee = qr.query(sql, new BeanHandler<Employee>(Employee.class), 3);

        // 4.获取数据
        System.out.println(employee);
    }

    /**
     * 查询薪资大于30000的员工信息，封装到JavaBean中再封装到List集合中
     * BeanListHandler 将结果集的每一条数据封装到JavaBean中 再放到集合中
     */
    @Test
    public void testFindBySalary() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employees where salary > ?";
        List<Employee> query = qr.query(sql, new BeanListHandler<Employee>(Employee.class), 30000);

        query.forEach(System.out::println);
    }

    /**
     * 查询姓名是Jane的员工信息，将结果封装到Map集合中
     * MapHandler将结果集中的每一条记录封装到Map<String, Object>中
     * key对应的是 列名 value对应的是列的值
     */
    @Test
    public void testFindByName() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employees where first_name = ?";
        Map<String, Object> map = qr.query(sql, new MapHandler(), "Jane");
        // 1.for循环
//        Set<Map.Entry<String, Object>> entries = map.entrySet();
//        for (Map.Entry<String, Object> entry : entries) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
        // 2.map.forEach
//        map.forEach((key, o) -> {
//            System.out.println(key + "=" + o);
//        });
        // 3.entrySet.forEach
        map.entrySet().forEach(System.out::println);
    }

    /**
     * 查询所有员工的薪资总额
     * ScalarHandler 用户封装单个的数据
     */
    @Test
    public void testCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select sum(salary) from employees";
        Object sum = qr.query(sql, new ScalarHandler<>());
        System.out.println("summary = " + sum.getClass());
    }

}
