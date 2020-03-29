package com.group.ctms.service.impl;

import com.group.ctms.dao.AuditLogMapper;
import com.group.ctms.entity.AuditLog;
import com.group.ctms.service.IAuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 操作日志服务实现
 */
@SuppressWarnings("unused")
@Service
public class AuditServiceImpl implements IAuditLogService{

    @Autowired
    private AuditLogMapper auditLogMapper;

    /**
     * 根据申请单的id查询和这个申请单相关的日志
     *
     * @param id 申请单id
     * @return 返回操作日志的list集
     */
    @Override
    public List<AuditLog> logList(int id) {
        return auditLogMapper.logList(id);
    }

    /**
     * 添加一条操作日志
     * @param auditLog 日志对象
     */
    @Override
    public void addAuditLog(AuditLog auditLog) {
        auditLogMapper.addAuditLog(auditLog);
    }
}
