package com.group.ctms.service.impl;

import com.group.ctms.dao.ApplicationMapper;
import com.group.ctms.dao.AuditLogMapper;
import com.group.ctms.dao.AuthorityMapper;
import com.group.ctms.dao.EmployeeMapper;
import com.group.ctms.entity.Application;
import com.group.ctms.entity.AuditLog;
import com.group.ctms.entity.Authority;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.ICheckService;
import com.group.ctms.util.Const;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by zcy-fover on 2016/11/14.
 * 审批管理服务方法具体实现
 */
@SuppressWarnings("unused")
@Service
public class CheckServiceImpl implements ICheckService{

    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private AuditLogMapper auditLogMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private AuthorityMapper authorityMapper;

    /**
     * 传入操作人和申请单id，用来更新申请单状态并在操作日志中添加一条记录
     *
     * @param session 进行审核的员工session信息
     * @param application 申请单id
     * @param auditFeedback 操作反馈信息
     * @return 将处理的结果返回
     */
    @Override
    public Result checkApp(HttpSession session, Application application, String auditFeedback) {


        //获取完整的用户信息
        Employee employee = (Employee) session.getAttribute(Const.USER_SESSION_KEY);

        //初始化一条操作日志
        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(employee.getId());
        auditLog.setUsername(employee.getEmployeeName());
        auditLog.setApplicationId(application.getId());
        auditLog.setAuditDate(new Date());
        auditLog.setAuditType(2);//2表示审批

        //根据审批的状态，添加一条操作日志
        if (application.getCheckState() == -1){
            //未通过时将申请单状态变为-1
            application.setCheckState(-1);
            //添加操作日志中的信息
            auditLog.setAuditResult(2);//2表示审批未通过
            auditLog.setAuditFeedback(auditFeedback);
        } else {
            //通过时，根据当前状态码自动获取下一个审批状态码
            application.setCheckState(nextApprovalState(application.getCheckState()));
            auditLog.setAuditResult(1);//1表示审批通过
        }
        //更新申请单的状态
        boolean flag1 = applicationMapper.reviseApplication(application);
        //添加一条操作日志
        boolean flag2 = auditLogMapper.addAuditLog(auditLog);

        Result result = new Result();
        if (flag1 && flag2){
            result.setMessage("审核成功");
        } else {
            result.setMessage("审核失败");
        }
        return result;
    }

    /**
     * 根据当前的审批状态码获取下一个审批状态码
     * @param currentState 当前的审批状态码
     * @return 返回下一个审批状态码
     */
    private int nextApprovalState(int currentState){
        Map<Integer, Authority> map = new HashMap<>();
        List<Authority> list = authorityMapper.listAllAuthority();
        for (Authority authority:list) {
            map.put(authority.getApprovalState(), authority);
        }

        Set<Integer> stateSet = map.keySet();
        Integer[] temp = new Integer[stateSet.size()];
        Integer[] stateArray = stateSet.toArray(temp);
        Arrays.sort(stateArray);
        for (int i = 0; i < stateArray.length -1 ; i++){
            if (stateArray[i] == currentState){
                return stateArray[i + 1];
            }
        }
        //如果在上面的if中没有返回，则说明当前工单状态已经是最后一个状态了，则将该工单的状态设为100
        return 100;
    }

}
