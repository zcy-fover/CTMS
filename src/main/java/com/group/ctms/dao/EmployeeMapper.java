package com.group.ctms.dao;

import com.group.ctms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/10.
 * 员工类的映射数据库文件，主要是员工的CRUD
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeMapper {

    /**
     * 通过员工表记录的id查询员工
     * @param id 记录的id
     * @return 返回一个员工
     */
    Employee findEmployeeById(int id);

    /**
     * 通过员工工号查询
     * @param employeeNum 员工工号
     * @return 因为工号是唯一的，返回是一个Employee对象
     */
    Employee findEmployeeByNum(int employeeNum);

    /**
     * 查询所有员工
     * @return 返回一个list集
     */
    List<Employee> findEmployeeList();

    /**
     * 封装查询条件，进行查询
     * @param employee 查询对象
     * @return 返回满足条件的employee的list集
     */
    List<Employee> queryEmployeeList(Employee employee);

    /**
     * 添加员工
     * @param employee 一个新的员工对象
     * @return 返回操作结果
     */
    boolean addEmployee(Employee employee);

    /**
     * 更新一个员工对象
     * @param employee 更新的员工信息
     * @return 返回操作结果
     */
    boolean updateEmployee(Employee employee);

    /**
     * 通过员工工号删除员工
     * @param employeeNum 工号
     * @return 返回操作结果
     */
    boolean deleteEmployee(int employeeNum);
}
