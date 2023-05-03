package com.mume.Module01_jdbc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * JAVABean类
 *          用来存储数据 成员变量私有 提供get set 提供空参 实现序列化接口
 * Employee类 就是对应数据库中的Employee表
 * @author mume
 */

public class Employee implements Serializable {

    private static final long serialVersionUID = -777227585364633409L;

    private int id;

    private String first_name;

    private String last_name;

    private String email;

    private Date hire_date;

    private Double salary;

    public Employee(int id, String first_name, String last_name, String email, Date hire_date, Double salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.hire_date = hire_date;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Objects.equals(getFirst_name(), employee.getFirst_name()) && Objects.equals(getLast_name(), employee.getLast_name()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getHire_date(), employee.getHire_date()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirst_name(), getLast_name(), getEmail(), getHire_date(), getSalary());
    }
}
