package com.group.ctms.controller;

import com.group.ctms.entity.Department;
import com.group.ctms.entity.Employee;
import com.group.ctms.entity.Role;
import com.group.ctms.service.IDepartmentService;
import com.group.ctms.service.IEmployeeService;
import com.group.ctms.service.IRoleService;
import com.group.ctms.service.IWebService;
import com.group.ctms.util.Const;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zcy-fover on 2016/11/10.
 * 前端控制器，主要管理登录、注册、登出等业务
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping
public class WebController {

    @Autowired
    private IWebService webService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        //获取注册需要的信息，查询公司内所有的部门
        List<Department> listDept = departmentService.getAllDept();
        //包装所有的部门
        modelAndView.addObject("listDept", listDept);

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(Employee employee, HttpSession session){

        ModelAndView modelAndView = new ModelAndView();

        if (employee.getEmployeeNum() == null){
            modelAndView.setViewName("login");
            return modelAndView;
        }

        //查询数据库，用户登录信息是否正确，包装返回信息
        Result result = webService.findEmployeeByNum(employee.getEmployeeNum(), employee.getPassword());
        modelAndView.addObject("result", result);
        List<Department> listDept = departmentService.getAllDept();
        //包装所有的部门
        modelAndView.addObject("listDept", listDept);

        if (result.isSuccess()){
            //获取用户详细信息
            employee = employeeService.findEmployeeByNum(employee.getEmployeeNum());
            modelAndView.addObject("user", employee);
            //获取用户的角色
            Role role = roleService.getRoleById(employee.getRoleId());
            modelAndView.addObject("userRole", role);

            //将登录的用户信息保存到session中
            session.setAttribute(Const.USER_SESSION_KEY, employee);
            session.setAttribute("user", employee);
            session.setAttribute("userRole", role);
            //设定返回页面
            modelAndView.setViewName("home");
        } else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        Result result = employeeService.addEmployee(employee);
        modelAndView.addObject("result", result);
        System.out.println(result);
        //设定返回页面
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession httpSession){
        httpSession.removeAttribute(Const.USER_SESSION_KEY);
        httpSession.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/toHome")
    public ModelAndView toHome(ModelAndView view){
        view.setViewName("home");
        return view;
    }

}
