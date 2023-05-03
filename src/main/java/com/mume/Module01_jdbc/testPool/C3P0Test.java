package com.mume.Module01_jdbc.testPool;

import com.mume.Module01_jdbc.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class C3P0Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = C3P0Utils.getConnection();

        String sql = "select * from employees where first_name = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, "John");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int eid = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            Date date = resultSet.getDate("hire_date");
            Double salary = resultSet.getDouble("salary");
            System.out.println(eid + " " + first_name + " " + last_name + " " + email + " " + date + " " + salary);
        }

        C3P0Utils.close(connection, ps);
    }
}
