package com.group.ctms.entity;

/**
 * Created by Doctor Who on 2016/11/10.
 * 权限实体
 */
@SuppressWarnings("unused")
public class Authority {

    /**
     * id : 1
     * userId : 1         ---------审批者工号
     * username : david   ---------审批者姓名
     * userRoleId :       ---------审批者角色,从角色表中加载
     * approvalOrder : 3  ---------审批顺序
     * approvalState : 1  ---------审批状态码 10：部门经理 20：财务经理 30：行政经理； 成功状态码设为100
     * deletedMark:0      ---------删除标志 0：正常  1：已删除
     */

    private Integer id;
    private Integer userId;
    private String username;
    private Integer userRoleId;
    private Integer approvalOrder;
    private Integer approvalState;
    private Integer deletedMark;

    public void setDeletedMark(Integer deletedMark) {
        this.deletedMark = deletedMark;
    }

    public Integer getDeletedMark() {
        return deletedMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getApprovalOrder() {
        return approvalOrder;
    }

    public void setApprovalOrder(Integer approvalOrder) {
        this.approvalOrder = approvalOrder;
    }

    public Integer getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(Integer approvalState) {
        this.approvalState = approvalState;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", userRoleId='" + userRoleId + '\'' +
                ", approvalOrder=" + approvalOrder +
                ", approvalState=" + approvalState +
                ", deletedMark=" + deletedMark +
                '}';
    }
}
