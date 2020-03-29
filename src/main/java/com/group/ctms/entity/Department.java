package com.group.ctms.entity;

/**
 * Created by Doctor Who on 2016/11/10.
 * 部门实体
 */
@SuppressWarnings("unused")
public class Department {

    /**
     * id : 1
     * deptName : HR             -----部门名称
     * responsiblePersonId : 34  -----负责人ID
     * deletedMark : 2           -----删除标志
     */

    private Integer id;
    private String deptName;
    private Integer responsiblePersonId;
    private Integer deletedMark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getResponsiblePersonId() {
        return responsiblePersonId;
    }

    public void setResponsiblePersonId(Integer responsiblePersonId) {
        this.responsiblePersonId = responsiblePersonId;
    }

    public Integer getDeletedMark() {
        return deletedMark;
    }

    public void setDeletedMark(Integer deletedMark) {
        this.deletedMark = deletedMark;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", responsiblePersonId=" + responsiblePersonId +
                ", deletedMark=" + deletedMark +
                '}';
    }
}
