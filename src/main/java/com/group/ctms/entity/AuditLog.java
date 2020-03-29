package com.group.ctms.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Doctor Who on 2016/11/10.
 * 操作日志实体
 */
@SuppressWarnings("unused")
public class AuditLog {


    /**
     * id : 1
     * applicationId : 1  ----------------申请表ID
     * userId : 1          ----------------操作者ID
     * username : doctor who --------------操作者姓名
     * auditType : 2         --------------操作类型  1：提交申请 2：审批
     * auditResult : 2       --------------操作结果  1：审批通过 2：审批未通过
     * auditFeedback : rip   --------------操作反馈 注：当审核不通过向申请者反馈并要求修改信息或放弃申请
     * auditDate : 2016-11-10 12:34:34 ----操作时间
     */

    private Integer id;
    private Integer applicationId;
    private Integer userId;
    private String username;
    private Integer auditType;
    private Integer auditResult;
    private String auditFeedback;
    @DateTimeFormat
    private Date auditDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    public String getAuditFeedback() {
        return auditFeedback;
    }

    public void setAuditFeedback(String auditFeedback) {
        this.auditFeedback = auditFeedback;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", applicationId=" + applicationId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", auditType=" + auditType +
                ", auditResult=" + auditResult +
                ", auditFeedback='" + auditFeedback + '\'' +
                ", auditDate=" + auditDate +
                '}';
    }
}
