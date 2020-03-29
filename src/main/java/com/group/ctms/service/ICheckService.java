package com.group.ctms.service;

import com.group.ctms.entity.Application;
import com.group.ctms.util.Result;

import javax.servlet.http.HttpSession;

/**
 * Created by zcy-fover on 2016/11/14.
 * 审批管理服务方法
 */
@SuppressWarnings("unused")
public interface ICheckService {
    /**
     * 传入操作人和申请单id，用来更新申请单状态并在操作日志中添加一条记录
     * @param session 进行审核的员工的session信息
     * @param application 申请单
     * @param auditFeedback 操作反馈信息
     * @return 将处理的结果返回
     */
    Result checkApp(HttpSession session, Application application, String auditFeedback);
}
