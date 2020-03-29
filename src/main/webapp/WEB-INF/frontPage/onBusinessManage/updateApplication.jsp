<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<script src="/assets/js/applicationSubmit.js"></script>

<div class="application-box-body">
    <form id="query-form" action="/application/update" method="post" class="form-horizontal">
        <input id="pageNum" name="pageNum" value="${page.pageNum}" hidden="hidden">
        <input id="pageSize" name="pageSize" value="${page.pageSize}" hidden="hidden">
        <input type="hidden" value="${application.id}" name="id">
        <div class="form-group has-feedback">
            <label class="col-sm-2 control-label">工号</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" name="employeeNum" placeholder="员工工号" value="${sessionScope.user.employeeNum}" readonly="readonly">
                <span class="fa fa-user form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-feedback">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" name="employeeName" placeholder="姓名" value="${sessionScope.user.employeeName}"  readonly="readonly">
                <span class="fa fa-user form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-feedback">
            <label class="col-sm-2 control-label">出差<br/>事由</label>
            <div class="col-lg-10">
                <textarea type="text" class="form-control" name="reason" placeholder="出差事由" row="4">${application.reason}</textarea>
                <span class="fa fa-user form-control-feedback"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="form-group has-feedback">
                    <label class="col-sm-4 control-label">开始时间</label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" name="startDate" id="startDateId"  value="<fmt:formatDate value="${application.startDate}" dateStyle="default"/>" data-date-format="yyyy-mm-dd">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="form-group has-feedback">
                    <label class="col-sm-4 control-label">结束时间</label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" name="endDate"  value="<fmt:formatDate value="${application.endDate}" dateStyle="default"/>" id="endDateId" data-date-format="yyyy-mm-dd">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="form-group has-feedback">
                    <label class="col-sm-4 control-label">出差地点</label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" value="${application.destination}" name="destination">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="form-group has-feedback">
                    <label class="col-sm-4 control-label">交通工具</label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control"  value="${application.vehicle}" name="vehicle">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="form-group has-feedback">
                    <label class="col-sm-4 control-label">交通费</label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" value="${application.trafficFee}" name="trafficFee">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="form-group has-feedback">
                    <label class="col-sm-4 control-label">住宿费</label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" value="${application.accomodation}" name="accomodation">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                </div>
            </div>
        </div>
        <button id="application-button" type="submit" class="btn btn-primary btn-block btn-flat">提交申请</button>
    </form>
</div>

