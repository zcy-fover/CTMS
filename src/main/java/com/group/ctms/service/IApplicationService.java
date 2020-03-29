package com.group.ctms.service;

import com.github.pagehelper.PageInfo;
import com.group.ctms.entity.Application;
import com.group.ctms.entity.AuditLog;
import com.group.ctms.entity.Employee;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * Completed by Doctor Who on 2016/11/14
 * 申请服务接口
 */
public interface IApplicationService {
    /**
     * 根据传入的ID删除对应申请表
     * @param id
     * @return 操作是否成功
     */
    public boolean delApplication(Integer id);

    /**
     * 添加申请表
     * @param employeeNum 员工工号，借此查询该员工对象
     * @param application 获取的申请表
     * @return 操作是否成功
     */
    public boolean addApplication(Integer employeeNum, Application application);

    /**
     * 修改申请表
     * @param application 修改后的申请表
     * @return 操作是否成功
     */
    public boolean reviseApplication(Application application);

    /**
     * 封装查询条件，进行查询
     * @param application 查询对象
     * @param page 分页查询对象
     * @return 返回满足条件的application的list集
     */
    public PageInfo<Application> query(PageInfo<Application> page, Application application);

    public List<Application> queryApplication(Application application);

    /**
     * 显示所有未删除表单
     * @return 返回所有未删除的申请表集合
     */
    public PageInfo<Application> list(PageInfo<Application> page,Integer employeeNum);

    /**
     * 显示所有未删除表单
     * @param employeeNum
     * @return
     */
    public List<Application> listApplication(Integer employeeNum);

    /**
     * 添加一条操作日志
     * @param auditLog
     * @return 操作是否成功
     */
    public boolean addAuditLog(Application application, AuditLog auditLog);

    /**
     * 根据id查询申请表表
     * @param id
     * @return
     */
    public Application getApplicationById(Integer id);
}
