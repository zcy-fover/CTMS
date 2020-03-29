<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="../common/common-css.jsp"%>
</head>
<body class="hold-transition fix skin-blue sidebar-mini">

<div class="wrapper">
    <!--此处引入左边菜单和头文件-->
    <%@ include file="../common/header-left.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h4>
                <a href="${basePath}/toHome">首页</a>
            </h4>
        </section>

        <!-- 添加页面主要内容 -->
        <section class="content">
            <div class="container-fluid container-style">
                <form id="query-form" action="/check/query" method="post" class="form-horizontal">
                    <div class="col-lg-2">
                        <select name="deptId" class="form-control">
                            <option value="" style="display: none;">全部</option>
                            <c:forEach var="dept" items="${listDept}">
                                <option value="${dept.id}" <c:if test="${application.deptId == dept.id}">selected</c:if>>${dept.deptName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-1">
                        <button id="query-button" type="submit" class="btn btn-primary btn-block btn-flat">查询</button>
                    </div>
                </form>
            </div>

            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table">
                            <thead>
                            <tr>
                                <td>申请号</td>
                                <td>姓名</td>
                                <td>开始时间</td>
                                <td>结束时间</td>
                                <td>出差地点</td>
                                <td>交通费</td>
                                <td>住宿费</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listApp}" var="application">
                                <tr>
                                    <td>${application.id}</td>
                                    <td>${application.employeeName}</td>
                                    <td>
                                        <fmt:formatDate value="${application.startDate}" dateStyle="default"/>
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${application.endDate}" dateStyle="default"/>
                                    </td>
                                    <td>${application.destination}</td>
                                    <td>${application.trafficFee}</td>
                                    <td>${application.accomodation}</td>
                                    <td>
                                        <a class="btn btn-primary btn-flat" href="/check/detail?id=${application.id}">审批</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <!--此处引入脚-->
    <%@ include file="../common/foot.jsp"%>
</div>

<%--引入js文件--%>
<%@ include file="../common/common-js.jsp"%>
<script type="application/javascript">
    $(function () {
        var message = $('#message').text();
        if (message != '') {
            var title = message.split('|')[0];
            var msg = message.split('|')[1];
            console.log(title + ' | ' + msg);
            showAlert(title, msg, 'alert-info', false);
        }
    });
</script>
</body>
</html>
