package com.group.ctms;

import com.group.ctms.entity.AuditLog;
import com.group.ctms.service.IAuditLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by zcy-fover on 2016/11/17.
 * 操作日志测试方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
        "classpath:/spring/springMVC-config.xml"})
public class AuditLogTest {

    @Autowired
    private IAuditLogService service;

    @Test
    public void addTest(){
        AuditLog auditLog = new AuditLog();
        auditLog.setApplicationId(1);
        auditLog.setUsername("张四");
        auditLog.setUserId(6);
        auditLog.setAuditDate(new Date());
        auditLog.setAuditResult(1);
        auditLog.setAuditType(1);
        auditLog.setAuditFeedback("测试");
        service.addAuditLog(auditLog);
    }

    @Test
    public void list(){
        List<AuditLog> auditLogs = service.logList(20);
        for (AuditLog a:auditLogs
             ) {
            System.out.println(a.getAuditDate());
        }
    }
}
