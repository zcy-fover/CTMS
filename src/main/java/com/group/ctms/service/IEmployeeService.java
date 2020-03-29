package com.group.ctms.service;

import com.github.pagehelper.PageInfo;
import com.group.ctms.entity.Employee;
import com.group.ctms.util.Result;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/14.
 * 员工服务方法接口
 */
@SuppressWarnings("unused")
public interface IEmployeeService {

    /**
     * 通过员工表记录的id查询员工
     * @param id 记录的id
     * @return 返回一个员工
     */
    Employee findEmployeeById(int id);

    /**
     * 通过员工工号查询员工
     * @param employeeNum 工号
     * @return 返回一个员工
     */
    Employee findEmployeeByNum(int employeeNum);

    /**
     * 查询所有员工
     * @return 返回一个list集
     */
    PageInfo<Employee> findEmployeeList(PageInfo<Employee> page);

    /**
     * 封装查询条件，进行查询
     * @param employee 查询对象
     * @param page 分页查询对象
     * @return 返回满足条件的employee的list集
     */
    PageInfo<Employee> queryEmployeeList(PageInfo<Employee> page, Employee employee);

    /**
     * 添加员工
     * @param employee 一个新的员工对象
     * @return 返回操作结果
     */
    Result addEmployee(Employee employee);

    /**
     * 更新一个员工对象
     * @param employee 更新的员工信息
     * @return 返回操作结果
     */
    Result updateEmployee(Employee employee);

    /**
     * 通过员工工号删除员工
     * @param employeeNum 工号
     * @return 返回操作结果
     */
    Result deleteEmployee(int employeeNum);
}
