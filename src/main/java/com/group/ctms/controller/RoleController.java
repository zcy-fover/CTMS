package com.group.ctms.controller;

import com.group.ctms.entity.Role;
import com.group.ctms.service.IRoleService;
import com.group.ctms.util.Result;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 角色控制器，管理角色的添加、修改等
 */
//@SuppressWarnings("unused")
@Controller
@RequestMapping("/role")
public class RoleController {
    private IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService){
        this.roleService = roleService;
    }

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        if (modelAndView == null){
            modelAndView = new ModelAndView();
        }
        List<Role> roles = roleService.getAllRole();
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("authorityManage/roleDetail");
        return modelAndView;
    }

    //根据传入的Id判断执行添加抑或修改操作
    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        if (id == null){
            modelAndView.setViewName("authorityManage/addRole");
            return modelAndView;
        }else{
            Role role = roleService.getRoleById(id);
            modelAndView.setViewName("authorityManage/updateRole");
            modelAndView.addObject("role", role);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(Role role, HttpServletRequest request){
        System.out.println(request.getCharacterEncoding());
        ModelAndView modelAndView = new ModelAndView();
        Result result = new Result();
        if (role.getId() != null){
           if (roleService.reviseRole(role)){
               result.setMessage("修改成功！");
            }else{
                result.setMessage("修改失败！");
           }
        }else {
            role.setDeletedMark(0);
            if (roleService.addRole(role)){
               result.setMessage("添加成功！");
            }else {
               result.setMessage("添加失败！");
            }
        }
        modelAndView.addObject("result", result);
        return list(modelAndView);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Result result = new Result();
        if (roleService.deleteRole(id)){
            result.setMessage("删除成功！");
        }else{
            result.setMessage("删除失败！");
        }
        modelAndView.addObject("result", result);
        return list(modelAndView);
    }

}
