<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="../common/common-css.jsp"%>
    <link rel="stylesheet" href="/assets/css/modify.css">
</head>
<body class="hold-transition fix skin-blue sidebar-mini">
<div class="wrapper">

    <!--此处引入左边菜单和头文件-->
    <%@ include file="../common/header-left.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h4>
                <a href="${basePath}/toHome">首页</a>-><a href="${basePath}/employee/list?pageNum=1&pageSize=8">用户列表</a>
            </h4>
        </section>

        <!-- 添加页面主要内容 -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="modify">
                <div class="modify-box-msg">
                    <h3>用户信息详情</h3>
                </div>
                <div class="modify-box-body" style="width: 400px; margin-left: 200px">
                    <label class="col-sm-3 control-label">员工工号</label>
                    <div class="col-lg-9">
                        <div class="form-group has-feedback">
                            <p>${employee.employeeNum}</p>
                            <span class="fa fa-user form-control-feedback"></span>
                        </div>
                    </div>
                    <label class="col-sm-3 control-label">员工姓名</label>
                    <div class="col-lg-9">
                        <div class="form-group has-feedback">
                            <p>${employee.employeeName}</p>
                            <span class="fa fa-envelope form-control-feedback"></span>
                        </div>
                    </div>
                    <label class="col-sm-3 control-label">归属部门</label>
                    <div class="col-lg-9">
                        <div class="form-group has-feedback">
                            <p>
                                <c:forEach var="dept" items="${listDept}">
                                    <c:if test="${dept.id == employee.deptId}">
                                        ${dept.deptName}
                                    </c:if>
                                </c:forEach>
                            </p>
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