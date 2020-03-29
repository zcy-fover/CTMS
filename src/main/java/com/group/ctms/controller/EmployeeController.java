package com.group.ctms.controller;

import com.github.pagehelper.PageInfo;
import com.group.ctms.entity.Department;
import com.group.ctms.entity.Employee;
import com.group.ctms.entity.Role;
import com.group.ctms.service.IDepartmentService;
import com.group.ctms.service.IEmployeeService;
import com.group.ctms.service.IRoleService;
import com.group.ctms.util.Page;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 员工控制器，管理员工的添加信息查看等
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/toEdit")
    public ModelAndView toEditEmployee(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);
        if (id == null) {
            modelAndView.setViewName("userManage/employeeAdd");
            return modelAndView;
        } else {
            Employee employee = employeeService.findEmployeeById(id);
            modelAndView.setViewName("userManage/employeeEdit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }
    }

    @RequestMapping("/save")
    public ModelAndView save(Employee employee, PageInfo<Employee> page){
        ModelAndView modelAndView = new ModelAndView();
        Result result;
        new Result();
        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);

        if (employee.getId() == null) {
            //执行添加员工
            result = employeeService.addEmployee(employee);
            //获取所有员工列表，将页面转到员工列表页，并封装执行信息
            page = employeeService.findEmployeeList(page);
            modelAndView.addObject("page", page);

            modelAndView.addObject("result", result);
            modelAndView.setViewName("userManage/employeeList");
            return modelAndView;
        } else {
            //执行修改，修改完后，回到详情页面。展示刚才修改的信息
            result = employeeService.updateEmployee(employee);
            employee = employeeService.findEmployeeById(employee.getId());
            modelAndView.addObject("result", result);
            modelAndView.addObject("employee", employee);

            modelAndView.setViewName("userManage/employeeDetail");
            return modelAndView;
        }
    }

    @RequestMapping("/list")
    public ModelAndView list(PageInfo<Employee> page, ModelAndView modelAndView){
        page = employeeService.findEmployeeList(page);
        modelAndView.addObject("page", page);
        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);
        //获取角色列表
        List<Role> listRole = roleService.getAllRole();
        modelAndView.addObject("listRole", listRole);

        modelAndView.setViewName("userManage/employeeList");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Integer employeeNum, PageInfo<Employee> page){
        ModelAndView modelAndView = new ModelAndView();
        Result result;
        new Result();
        //删除员工
        result = employeeService.deleteEmployee(employeeNum);
        modelAndView.addObject("result", result);
        return list(page, modelAndView);
    }

    @RequestMapping("/query")
    public ModelAndView query(Employee employee, PageInfo<Employee> page){
        ModelAndView modelAndView = new ModelAndView();
        page = employeeService.queryEmployeeList(page, employee);
        modelAndView.addObject("page", page);

        //查询条件返回
        modelAndView.addObject("employee", employee);

        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);
        //获取角色列表
        List<Role> listRole = roleService.getAllRole();
        modelAndView.addObject("listRole", listRole);

        modelAndView.setViewName("userManage/employeeList");
        return modelAndView;
    }

}
