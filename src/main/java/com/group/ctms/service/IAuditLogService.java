package com.group.ctms.service;

import com.group.ctms.entity.AuditLog;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 操作日志服务接口
 */
@SuppressWarnings("unused")
public interface IAuditLogService {
    /**
     * 根据申请单的id查询和这个申请单相关的日志
     * @param id 申请单id
     * @return 返回操作日志的list集
     */
    List<AuditLog> logList(int id);

    /**
     * 添加一条操作日志
     * @param auditLog 日志对象
     * @return 返回是否成功
     */
    void addAuditLog(AuditLog auditLog);
}
