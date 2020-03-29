<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <%@ include file="../common/common-css.jsp"%>
</head>
<body class="hold-transition fix skin-blue sidebar-mini">
<span id="message" style="display: none">${result.message}</span>
<!--alert-begin-->
<div>
    <div id="alert" class="alert alert-dismissible" style="display: none;">
        <button type="button" class="close" aria-hidden="true">×</button>
        <h4></h4>
        <p></p>
    </div>
</div>
<!--alert-end-->
<div class="wrapper">

    <!--此处引入左边菜单和头文件-->
    <%@ include file="../common/header-left.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h4>
                <a href="${basePath}/toHome">首页</a>-><a href="${basePath}/application/queryAll?pageNum=1&pageSize=8">出差申请</a>
            </h4>
        </section>

        <!-- 添加页面主要内容 -->
        <section class="content">
            <div class="application-box-body " style="width: 600px">
                <form id="application-form" class="form-horizontal">
                    <input type="hidden" value="${application.id}" name="id">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">工号</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="employeeNum" placeholder="员工工号" value="${sessionScope.user.employeeNum}" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">姓名</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="employeeName" placeholder="姓名" value="${sessionScope.user.employeeName}"  readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">开始时间</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="startDate" id="startDateId"  value="<fmt:formatDate value="${application.startDate}" dateStyle="default"/>" data-date-format="yyyy-mm-dd" readonly="readonly">
                                    <span class="add-on"><i class="icon-th"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">结束时间</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="endDate"  value="<fmt:formatDate value="${application.endDate}" dateStyle="default"/>" id="endDateId" data-date-format="yyyy-mm-dd" readonly="readonly">
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
                                    <input type="text" class="form-control" value="${application.destination}" name="destination" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">交通工具</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control"  value="${application.vehicle}" name="vehicle" readonly="readonly">
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
                                    <input type="text" class="form-control" value="${application.trafficFee}" name="trafficFee" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">住宿费</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" value="${application.accomodation}" name="accomodation" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="col-sm-2 control-label">出差<br/>事由</label>
                        <div class="col-lg-10">
                            <textarea type="text" class="form-control" name="reason" placeholder="出差事由" row="4" readonly="readonly">${application.reason}</textarea>
                            <span class="fa fa-user form-control-feedback"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table" style="text-align: left">
                            <thead>
                            <tr>
                                <td>日志ID</td>
                                <td>操作者姓名</td>
                                <td>操作时间</td>
                                <td>操作类型</td>
                                <td>结果</td>
                                <td>反馈</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${auditLogs}" var="auditLog">
                                <tr>
                                    <td>${auditLog.id}</td>
                                    <td>${auditLog.username}</td>
                                    <td>
                                        <fmt:formatDate value="${auditLog.auditDate}" type="both"/>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${auditLog.auditType == '1'}">
                                                提交申请
                                            </c:when>
                                            <c:when test="${auditLog.auditType == '2'}">
                                                审批
                                            </c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:if test="${auditLog.auditType != '1'}">
                                            <c:choose>
                                                <c:when test="${auditLog.auditResult == '1'}">
                                                    审批通过
                                                </c:when>
                                                <c:when test="${auditLog.auditResult == '2'}">
                                                    审批不通过
                                                </c:when>
                                            </c:choose>
                                        </c:if>
                                    </td>
                                    <td>${auditLog.auditFeedback}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <%@ include file="../common/foot.jsp"%>
</div>
<%@ include file="../common/common-js.jsp"%>
<script src="/assets/js/userModify.js"></script>
</body>
</html>