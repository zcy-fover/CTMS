package com.group.ctms.controller;

import com.group.ctms.entity.Authority;
import com.group.ctms.entity.Employee;
import com.group.ctms.entity.Role;
import com.group.ctms.service.IAuthorityService;
import com.group.ctms.service.IEmployeeService;
import com.group.ctms.service.IRoleService;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/14.
 * 权限控制器，主要控制审批权限的管理
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private IAuthorityService authorityService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        if (modelAndView == null){
            modelAndView = new ModelAndView();
        }
        //获取所有的角色
        List<Role> listRole = roleService.getAllRole();
        modelAndView.addObject("listRole", listRole);

        List<Authority> authorityList = authorityService.listAllAuthority();
        modelAndView.addObject("authorityList", authorityList);
        modelAndView.setViewName("authorityManage/listAuthority");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addApprover(Authority authority) {
        ModelAndView modelAndView = new ModelAndView();
        Result result = authorityService.addApprover(authority);
        modelAndView.addObject("result", result);
        return list(modelAndView);
    }

    @RequestMapping("/delete")
    public ModelAndView deleteApprover(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Result result = new Result();
        if (authorityService.deleteApprover(id)){
            result.setMessage("删除成功!");
        }
        modelAndView.addObject("result", result);
        return list(modelAndView);
    }
}
