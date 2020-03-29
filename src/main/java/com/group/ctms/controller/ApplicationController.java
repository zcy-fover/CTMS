package com.group.ctms.controller;

import com.github.pagehelper.PageInfo;
import com.group.ctms.entity.Application;
import com.group.ctms.entity.AuditLog;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IApplicationService;
import com.group.ctms.service.IAuditLogService;
import com.group.ctms.util.Const;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * Completed by Doctor Who on 2016/11/14
 * 员工出差申请表的控制器，管理添加、修改等业务
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/application")
public class ApplicationController {
    private IApplicationService applicationService;
    private IAuditLogService auditLogService;

    @Autowired
    public ApplicationController(IApplicationService applicationService,
                                 IAuditLogService auditLogService){
        this.applicationService = applicationService;
        this.auditLogService = auditLogService;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(PageInfo<Application> page){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page",page);
        modelAndView.setViewName("onBusinessManage/addApplication");
        return modelAndView;
    }

    /**
     * 添加申请表
     * @param application
     * @return
     */
    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    public ModelAndView commit(HttpSession httpSession, Application application, PageInfo<Application> page)
    {
        Employee employee = (Employee)httpSession.getAttribute(Const.USER_SESSION_KEY);
        ModelAndView modelAndView = new ModelAndView();
        Result result = new Result();
        AuditLog auditLog = new AuditLog();
        if (applicationService.addApplication(employee.getEmployeeNum(), application)){
            result.setMessage("添加成功!");
            auditLog.setAuditFeedback("提交成功");
            applicationService.addAuditLog(application, auditLog);
        }else {
            result.setMessage("添加失败!");
        }
        page = applicationService.list(page,employee.getEmployeeNum());
        modelAndView.addObject("page",page);
        modelAndView.addObject("result", result);
        return queryAll(page,httpSession,modelAndView);
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Integer id,PageInfo<Application> page){
        Application application = applicationService.getApplicationById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page",page);
        modelAndView.addObject("application", application);
        modelAndView.setViewName("onBusinessManage/updateApplication");
        return modelAndView;
    }
    /**
     * 修改申请表
     * @param application
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpSession httpSession,Application application, PageInfo<Application> page){
        Result result = new Result();
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = (Employee)httpSession.getAttribute(Const.USER_SESSION_KEY);
        AuditLog auditLog = new AuditLog();
        if (applicationService.reviseApplication(application)){
            result.setMessage("修改成功!");
            auditLog.setAuditFeedback("修改成功!");
            applicationService.addAuditLog(application,auditLog);
        }else {
            result.setMessage("修改失败!");
        }
        page = applicationService.list(page,employee.getEmployeeNum());
        modelAndView.addObject("page",page);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("onBusinessManage/applicationList");
        return modelAndView;
    }

    /**
     * 删除申请表
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam Integer id,HttpSession httpSession, PageInfo<Application> page){
        Result result = new Result();
        Employee employee = (Employee)httpSession.getAttribute(Const.USER_SESSION_KEY);
        if (applicationService.delApplication(id)){
            result.setMessage("删除成功!");
        }else{
            result.setMessage("删除失败!");
        }
        page = applicationService.list(page, employee.getEmployeeNum());

        if (page.getSize() == 0){
            page.setPageNum(page.getPageNum() - 1);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",result);

        modelAndView.addObject("page",page);
        return queryAll(page,httpSession,modelAndView);
    }

    /**
     * 根据输入的条件查询符合条件的表单
     * @param application
     * @return
     */
    @RequestMapping("/query")
    public ModelAndView query(PageInfo<Application> page, HttpSession httpSession,Application application){
        Employee employee = (Employee)httpSession.getAttribute(Const.USER_SESSION_KEY);
        application.setEmployeeNum(employee.getEmployeeNum());
        page = applicationService.query(page,application);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", page);
        modelAndView.setViewName("onBusinessManage/applicationList");
        return modelAndView;
    }

    /**
     * 查询所有未删除的表单并显示
     * @return
     */
    @RequestMapping("/queryAll")
    public ModelAndView queryAll(PageInfo<Application> page,HttpSession httpSession, ModelAndView modelAndView){
        Employee employee = (Employee)httpSession.getAttribute(Const.USER_SESSION_KEY);
        if (modelAndView == null){
            modelAndView = new ModelAndView();
        }
        page = applicationService.list(page,employee.getEmployeeNum());
        modelAndView.addObject("page",page);
        modelAndView.setViewName("onBusinessManage/applicationList");
        return modelAndView;
    }

    /**
     * 查看申请的详情
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public ModelAndView detail(Integer id){
        Application application = applicationService.getApplicationById(id);
        List<AuditLog> auditLogs = auditLogService.logList(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auditLogs", auditLogs);
        modelAndView.addObject("application", application);
        modelAndView.setViewName("onBusinessManage/detail");
        return modelAndView;
    }
}
