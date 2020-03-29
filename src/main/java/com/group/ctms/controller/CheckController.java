package com.group.ctms.controller;

import com.group.ctms.entity.Application;
import com.group.ctms.entity.Authority;
import com.group.ctms.entity.Department;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IApplicationService;
import com.group.ctms.service.IAuthorityService;
import com.group.ctms.service.ICheckService;
import com.group.ctms.service.IDepartmentService;
import com.group.ctms.util.Const;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcy-fover on 2016/11/14.
 * 审批管理控制器
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private IApplicationService applicationService;
    @Autowired
    private ICheckService checkService;
    @Autowired
    private IAuthorityService authorityService;
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 获取当前待当前登录用户审批的申请单
     * @param session 会话session，从中获取登录用户的信息
     * @return 返回视图和数据
     */
    @RequestMapping("/checkList")
    public ModelAndView checkList(HttpSession session, ModelAndView modelAndView, Application application){
        //从session中获取当前登录用户
        Employee employee = (Employee) session.getAttribute(Const.USER_SESSION_KEY);
        //查找权限表，获取登陆用户的审批状态码
        Authority authority = authorityService.findApproverByUserId(employee.getId());
        //判断状态码是不是10，如果是10，则说明是部门经理级别的审批。则需要根据部门id和审批状态码
        //两个属性在申请单列表中获取待当前用户审批的申请单
        List<Application> listApp;
        //初始化一个application对象，用于保存查询条件
//        Application application = new Application();
        if (authority.getApprovalState() == 10){
            application.setCheckState(10);
            application.setDeptId(employee.getDeptId());
            listApp = applicationService.queryApplication(application);
        } else {
            //不是10，则说明是需要财务经理或者行政经理审批。则根据状态码直接查询
            application.setCheckState(authority.getApprovalState());
            listApp = applicationService.queryApplication(application);
        }
        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);

        //封装返回数据及视图
        modelAndView.setViewName("checkManage/checkList");
        modelAndView.addObject("listApp", listApp);
        return modelAndView;
    }

    /**
     * 根据申请单id查找申请单，将详细信息展示到审核页面
     * @param id 申请单的id
     * @return 返回该申请单的视图名和详细信息
     */
    @RequestMapping("/toCheck")
    public ModelAndView toCheck(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Application application = applicationService.getApplicationById(id);
        modelAndView.setViewName("checkManage/checkApp");
        modelAndView.addObject("application", application);
        return modelAndView;
    }

    /**
     * 从session中获取登录用户的信息，同时将申请单的id传到后台
     * @param session 会话中获取用户信息
     * @param application 获取需要审核的申请单的信息
     * @param auditFeedback 操作的反馈信息
     * @return 返回到申请单列表页面，在查询一下所有待审批申请单
     */
    @RequestMapping(value = "/checkApp")
    public ModelAndView checkApp(HttpSession session, Application application, String auditFeedback){
        ModelAndView modelAndView = new ModelAndView();
        Result result = checkService.checkApp(session, application, auditFeedback);
        modelAndView.addObject("result", result);
        return checkList(session, modelAndView, application);
    }

    /**
     * 根据输入的条件查询符合条件的表单
     * @param application
     * @return
     */
    @RequestMapping("/query")
    public ModelAndView query(HttpSession session, Application application){
        List<Application> listApp = applicationService.queryApplication(application);
        ModelAndView modelAndView = new ModelAndView();
        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);
        //封装返回数据及视图
        modelAndView.setViewName("checkManage/checkList");
        modelAndView.addObject("listApp", listApp);
        //将查询条件返回
        modelAndView.addObject("application", application);
        return checkList(session, modelAndView, application);
    }

    /**
     * 跳转到申请单的详情页面，待审核者产看并审核
     * @param id 申请单id
     * @return 返回申请单数据和详情页面
     */
    @RequestMapping("/detail")
    public ModelAndView appDetail(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        //包装所有的部门
        List<Department> listDept = departmentService.getAllDept();
        modelAndView.addObject("listDept", listDept);
        Application application = applicationService.getApplicationById(id);
        modelAndView.addObject("application", application);
        modelAndView.setViewName("checkManage/appDetail");
        return modelAndView;
    }

}
