package com.group.ctms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.ctms.dao.EmployeeMapper;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IEmployeeService;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/14.
 * 员工服务方法的具体实现
 */
@SuppressWarnings("unused")
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 通过员工表记录的id查询员工
     *
     * @param id 记录的id
     * @return 返回一个员工
     */
    @Override
    public Employee findEmployeeById(int id) {
        return employeeMapper.findEmployeeById(id);
    }

    /**
     * 通过员工工号查询员工
     *
     * @param employeeNum 工号
     * @return 返回一个员工
     */
    @Override
    public Employee findEmployeeByNum(int employeeNum) {
        return employeeMapper.findEmployeeByNum(employeeNum);
    }

    /**
     * 查询所有员工
     * @param page 分页查询对象
     * @return 返回一个list集
     */
    @Override
    public PageInfo<Employee> findEmployeeList(PageInfo<Employee> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Employee> list = employeeMapper.findEmployeeList();
        page = new PageInfo<>(list);
        return page;
    }

    /**
     * 封装查询条件，进行查询
     * @param page 分页查询对象
     * @param employee 查询对象
     * @return 返回满足条件的employee的list集
     */
    @Override
    public PageInfo<Employee> queryEmployeeList(PageInfo<Employee> page, Employee employee) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Employee> list = employeeMapper.queryEmployeeList(employee);
        page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加员工
     *
     * @param employee 一个新的员工对象
     * @return 返回操作结果
     */
    @Override
    public Result addEmployee(Employee employee) {
        Result result = new Result();
        employee.setRoleId(1);
        employee.setIsDelete(0);
        if (employeeMapper.addEmployee(employee)){
            result.setMessage("注册成功");
            result.setSuccess(true);
        } else {
            result.setMessage("注册失败");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 更新一个员工对象
     *
     * @param employee 更新的员工信息
     * @return 返回操作结果
     */
    @Override
    public Result updateEmployee(Employee employee) {
        Result result = new Result();
        if (employeeMapper.updateEmployee(employee)){
            result.setMessage("更新成功");
            result.setSuccess(true);
        } else {
            result.setMessage("更新失败");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 通过员工工号删除员工
     *
     * @param employeeNum 工号
     * @return 返回操作结果
     */
    @Override
    public Result deleteEmployee(int employeeNum) {
        Result result = new Result();
        if (employeeMapper.deleteEmployee(employeeNum)){
            result.setMessage("删除成功");
            result.setSuccess(true);
        } else {
            result.setMessage("删除失败");
            result.setSuccess(false);
        }
        return result;
    }
}
