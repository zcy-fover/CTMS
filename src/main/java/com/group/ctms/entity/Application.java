package com.group.ctms.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Doctor Who on 2016/11/10.
 * 申请表实体
 */
@SuppressWarnings("unused")
public class Application {

    /**
     * id : 1
     * employeeNum : 1         ----------员工工号
     * employeeName : doctor who  -------员工姓名
     * reason : homesick ----------------出差事由
     * deptId : 1       -----------------部门ID
     * startDate : 2016-11-10   ---------出差开始时间
     * endDate: 2016-11-30     ----------出差结束时间
     * destination : L.A ----------------出差地点
     * vehicle : train  -----------------交通工具
     * trafficFee : 2.6 -----------------交通费
     * accomodation : 23.34 -------------住宿费
     * deletedMark : 0      -------------删除标志 0(正常);1(已删除)
     * checkState : 10      -------------审批状态 -1：未通过 10：部门经理 20：财务经理 30：行政经理 100:通过
     */

    private Integer id;
    private Integer employeeNum;
    private String employeeName;
    private String reason;
    private Integer deptId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String destination;
    private String vehicle;
    private Double trafficFee;
    private Double accomodation;
    private Integer deletedMark;
    private Integer checkState;

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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {

        return endDate;
    }

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Double getTrafficFee() {
        return trafficFee;
    }

    public void setTrafficFee(Double trafficFee) {
        this.trafficFee = trafficFee;
    }

    public Double getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Double accomodation) {
        this.accomodation = accomodation;
    }

    public Integer getDeletedMark() {
        return deletedMark;
    }

    public void setDeletedMark(Integer deletedMark) {
        this.deletedMark = deletedMark;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", employeeNum=" + employeeNum +
                ", employeeName='" + employeeName + '\'' +
                ", reason='" + reason + '\'' +
                ", deptId=" + deptId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", destination='" + destination + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", trafficFee=" + trafficFee +
                ", accomodation=" + accomodation +
                ", deletedMark=" + deletedMark +
                ", checkState=" + checkState +
                '}';
    }
}
