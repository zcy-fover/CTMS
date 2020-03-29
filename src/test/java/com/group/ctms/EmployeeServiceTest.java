package com.group.ctms;

import com.github.pagehelper.PageInfo;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IEmployeeService;
import com.group.ctms.util.MD5;
import com.group.ctms.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 员工服务方法测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
                                   "classpath:/spring/springMVC-config.xml"})
@SuppressWarnings("unused")
public class EmployeeServiceTest {
    @Autowired
    private IEmployeeService service;

    @Test
    public void updateTest(){
        Employee employee = new Employee();
        employee.setEmployeeNum(1003);
        employee.setPassword(MD5.get("123456"));
        Result result;
        new Result();
        result = service.updateEmployee(employee);
        System.out.println(result.getMessage());
    }

    @Test
    public void listTest(){
        PageInfo<Employee> page = new PageInfo<Employee>();
        page.setPageNum(1);
        page.setPageSize(3);
        page = service.findEmployeeList(page);
        page.getList().forEach(System.out::println);
    }

    @Test
    public void deleteTest(){
        Result result;
        new Result();
        result = service.deleteEmployee(2006);
        System.out.println(result.getMessage());
    }

    @Test
    public void addTest(){
        Employee employee = new Employee();
        employee.setEmployeeNum(1000);
        employee.setEmployeeName("管理员");
        employee.setPassword(MD5.get("123456"));
        employee.setDeptId(6);
        employee.setRoleId(3);
        Result result;
        new Result();
        result = service.addEmployee(employee);
        System.out.println(result.getMessage());
    }

}
