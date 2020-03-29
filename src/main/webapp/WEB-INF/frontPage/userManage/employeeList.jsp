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
            <div class="container-fluid container-style" style="margin-left: -40px;">
                <form id="query-form" name="query-form" action="/employee/query" method="post" class="form-horizontal">
                    <input id="pageNum" name="pageNum" value="${page.pageNum}" hidden="hidden">
                    <input id="pageSize" name="pageSize" value="${page.pageSize}" hidden="hidden">
                    <div class="form-style has-feedback">
                        <label class="col-sm-1 control-label">工号</label>
                        <div class="col-lg-2">
                            <input type="text" class="form-control" name="employeeNum" placeholder="工号" value="${employee.employeeNum}">
                            <span class="fa fa-user form-control-feedback"></span>
                        </div>

                        <div class="col-lg-2">
                            <select name="deptId" class="form-control">
                                <option value="" style="display: none;">归属部门</option>
                                <c:forEach var="dept" items="${listDept}">
                                    <option value="${dept.id}" <c:if test="${dept.id == employee.deptId}">selected</c:if>>
                                            ${dept.deptName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-lg-1">
                            <button id="query-button" type="submit" class="btn btn-primary btn-block btn-flat">查询</button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td>员工工号</td>
                                    <td>员工姓名</td>
                                    <td>部门</td>
                                    <td>角色</td>
                                    <td>操作</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="employee" items="${page.list}">
                                    <tr>
                                        <td>${employee.employeeNum}</td>
                                        <td>${employee.employeeName}</td>
                                        <td>
                                            <c:forEach var="dept" items="${listDept}">
                                                <c:if test="${dept.id == employee.deptId}">
                                                    ${dept.deptName}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <c:forEach var="role" items="${listRole}">
                                                <c:if test="${role.id == employee.roleId}">
                                                    ${role.roleName}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <a  class=" btn btn-warning btn-flat" href="/employee/toEdit?id=${employee.id}">修改</a>
                                            <a  class=" btn btn-danger btn-flat" href="/employee/delete?employeeNum=${employee.employeeNum}">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="pagination pagination-large" style="margin-left: 360px; margin-top: 0px; margin-bottom: 0px;">
                            <%@ include file="../common/page.jsp"%>
                            <%--<ul class="pagination" >--%>
                                <%--<c:if test="${page.hasPreviousPage}">--%>
                                    <%--<li><a href="/employee/list?pageNum=${page.prePage}&pageSize=${page.pageSize}">前一页</a></li>--%>
                                <%--</c:if>--%>
                                <%--<c:forEach items="${page.navigatepageNums}" var="nav">--%>
                                    <%--<c:if test="${nav == page.pageNum}">--%>
                                        <%--<li style="color: #001f3f"><a href="/employee/list?pageNum=${nav}&pageSize=${page.pageSize}">${nav}</a></li>--%>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${nav != page.pageNum}">--%>
                                        <%--<li><a href="/employee/list?pageNum=${nav}&pageSize=${page.pageSize}">${nav}</a></li>--%>
                                    <%--</c:if>--%>
                                <%--</c:forEach>--%>
                                <%--<c:if test="${page.hasNextPage}">--%>
                                    <%--<li><a href="/employee/list?pageNum=${page.nextPage}&pageSize=${page.pageSize}">下一页</a></li>--%>
                                <%--</c:if>--%>
                            <%--</ul>--%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
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
