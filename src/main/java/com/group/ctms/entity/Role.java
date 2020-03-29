package com.group.ctms.entity;

/**
 * Created by Doctor Who on 2016/11/10.
 * 角色实体
 */
@SuppressWarnings("unused")
public class Role {

    /**
     * id : 1
     * roleName : king         --------------角色名
     * roleNum : 2             --------------角色编号
     * roleDesc : long live the king  -------角色描述
     * deletedMark: 0                 -------删除标志 0：正常 1：已删除
     */

    private Integer id;
    private String roleName;
    private Integer roleNum;
    private String roleDesc;
    private Integer deletedMark;

    public Integer getDeletedMark() {
        return deletedMark;
    }

    public void setDeletedMark(Integer deletedMark) {
        this.deletedMark = deletedMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(Integer roleNum) {
        this.roleNum = roleNum;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleNum=" + roleNum +
                ", roleDesc='" + roleDesc + '\'' +
                ", deletedMark=" + deletedMark +
                '}';
    }
}
