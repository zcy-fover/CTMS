package com.group.ctms;

import com.group.ctms.entity.Department;
import com.group.ctms.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/16.
 * 部门服务方法后台测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
        "classpath:/spring/springMVC-config.xml"})
@SuppressWarnings("unused")
public class DepartmentServiceTest {

    @Autowired
    private IDepartmentService service;

    @Test
    public void findDeptByIdTest(){
        Department department = service.getDeptById(1);
        System.out.println(department);
    }

    @Test
    public void getAllTest(){
        List<Department> list = service.getAllDept();
        list.forEach(System.out::println);
    }

}
