package com.group.ctms.entity;

/**
 * Created by zcy-fover on 2016/11/9.
 * 员工实体
 */
@SuppressWarnings("unused ")
public class Employee {
    /**
     * id : 134
     * employeeNum : 345   --------员工工号
     * password : wtf      --------密码
     * employeeName : David -------员工姓名
     * deptId : 132         -------部门ID
     * roleId : 34          -------角色ID
     * isDelete : 0         -------0：表示在职，1表示删除
     */

    private Integer id;
    private Integer employeeNum;
    private String password;
    private String employeeName;
    private Integer deptId;
    private Integer roleId;
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeNum=" + employeeNum +
                ", password='" + password + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", deptId=" + deptId +
                ", roleId=" + roleId +
                ", isDelete=" + isDelete +
                '}';
    }
}

