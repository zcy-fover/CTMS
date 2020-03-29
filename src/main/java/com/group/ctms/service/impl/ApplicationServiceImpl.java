package com.group.ctms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.ctms.dao.ApplicationMapper;
import com.group.ctms.dao.AuditLogMapper;
import com.group.ctms.dao.EmployeeMapper;
import com.group.ctms.entity.Application;
import com.group.ctms.entity.AuditLog;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * Completed by Doctor Who on 2016/11/14
 * 申请服务具体实现
 */
@SuppressWarnings("unused")
@Service
public class ApplicationServiceImpl implements IApplicationService {
    private ApplicationMapper applicationMapper;
    private AuditLogMapper auditLogMapper;
    private EmployeeMapper employeeMapper;

    @Autowired
    public ApplicationServiceImpl(ApplicationMapper applicationMapper,
                                  AuditLogMapper auditLogMapper, EmployeeMapper employeeMapper){
        this.applicationMapper = applicationMapper;
        this.auditLogMapper = auditLogMapper;
        this.employeeMapper = employeeMapper;
    }

    /**
     * 添加申请表
     * @param application
     * @return
     */
    @Override
    public boolean addApplication(Integer employeeNum, Application application) {
        //根据员工号查询该员工对象
        Employee employee = employeeMapper.findEmployeeByNum(employeeNum);
        //当员工级别为不同时根据部门不同审批状态码不同
        if (employee.getRoleId() == 1){
            switch (employee.getDeptId()){
                case 1:
                    application.setCheckState(20);
                    break;
                case 7:
                    application.setCheckState(30);
                    break;
                default:
                    application.setCheckState(10);
                    break;
            }
        }else {
            switch (employee.getDeptId()){
                case 1:
                    application.setCheckState(30);
                    break;
                case 7:
                    application.setCheckState(100);
                    break;
                default:
                    application.setCheckState(20);
                    break;
            }
        }
        application.setEmployeeNum(employeeNum);
        application.setEmployeeName(employee.getEmployeeName());
        application.setDeptId(employee.getDeptId());
        application.setDeletedMark(0);
        return applicationMapper.addApplication(application);
    }

    /**
     * 提交操作反馈表
     * @param auditLog
     * @return
     */
    @Override
    public boolean addAuditLog(Application application, AuditLog auditLog) {
        Date nowDate = new Date();
        auditLog.setApplicationId(application.getId());
        auditLog.setUserId(employeeMapper.findEmployeeByNum(application.getEmployeeNum()).getId());
        auditLog.setUsername(application.getEmployeeName());
        auditLog.setAuditType(1);
        auditLog.setAuditDate(nowDate);
        return auditLogMapper.addAuditLog(auditLog);
    }

    /**
     * 根据id查询申请表表
     * @param id
     * @return
     */
    @Override
    public Application getApplicationById(Integer id) {
        return applicationMapper.getApplicationById(id);
    }

    /**
     * 删除申请表
     * @param id
     * @return
     */
    @Override
    public boolean delApplication(Integer id) {
        return applicationMapper.delApplication(id);
    }

    /**
     * 修改申请表
     * @param application
     * @return
     */
    @Override
    public boolean reviseApplication(Application application) {
        //根据员工号查询该员工对象
        Employee employee = employeeMapper.findEmployeeByNum(application.getEmployeeNum());
        if (employee.getRoleId() == 1){
            switch (employee.getDeptId()){
                case 1:
                    application.setCheckState(20);
                    break;
                case 7:
                    application.setCheckState(30);
                    break;
                default:
                    application.setCheckState(10);
                    break;
            }
        }else {
            switch (employee.getDeptId()){
                case 1:
                    application.setCheckState(30);
                    break;
                case 7:
                    application.setCheckState(100);
                    break;
                default:
                    application.setCheckState(20);
                    break;
            }
        }
        return applicationMapper.reviseApplication(application);
    }

    /**
     *
     * @param page 分页查询对象
     * @param employeeNum 员工工号
     * @return 返回所有未删除的application的集合
     */
    @Override
    public PageInfo<Application> list(PageInfo<Application> page, Integer employeeNum) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Application> list = applicationMapper.listApplication(employeeNum);
        return new PageInfo<>(list);
    }

    @Override
    public List<Application> listApplication(Integer employeeNum) {
        return applicationMapper.listApplication(employeeNum);
    }

    /**
     *
     * @param page 分页查询对象
     * @param application 查询对象
     * @return 返回满足条件的application的集合
     */
    @Override
    public PageInfo<Application> query(PageInfo<Application> page,Application application) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Application> list = applicationMapper.queryApplication(application);
        return new PageInfo<>(list);
    }

    @Override
    public List<Application> queryApplication(Application application) {
        return applicationMapper.queryApplication(application);
    }

}
