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
                <a href="${basePath}/toHome">首页</a>-><a href="${basePath}/employee/list?pageNum=1&pageSize=8">用户列表</a>
            </h4>
        </section>

        <!-- 添加页面主要内容 -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="modify">
                <div class="modify-box-msg">
                    <p>用户信息修改</p>
                </div>
                <div class="modify-box-body">
                    <form id="modify-form" action="modify" method="post">
                        <label class="col-sm-2 control-label">员工工号</label>
                        <div class="col-lg-10">
                            <div class="form-group has-feedback">
                                <input type="text" class="form-control" name="employeeNum" placeholder="员工工号" readonly="readonly">
                                <span class="fa fa-user form-control-feedback"></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-lg-10">
                            <div class="form-group has-feedback">
                                <input type="text" class="form-control" name="employee_name" placeholder="姓名">
                                <span class="fa fa-envelope form-control-feedback"></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-lg-10">
                            <div class="form-group has-feedback">
                                <input type="password" class="form-control" name="password" placeholder="密码">
                                <span class="fa fa-lock form-control-feedback"></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">重复密码</label>
                        <div class="col-lg-10">
                            <div class="form-group has-feedback">
                                <input type="password" class="form-control" name="retypePassword" placeholder="重新输入密码">
                                <span class="fa fa-lock form-control-feedback"></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">归属部门</label>
                        <div class="col-lg-10">
                            <div class="form-group has-feedback">
                                <select name="department" class="form-control">
                                    <option value="" style="display: none;">归属部门</option>
                                    <c:forEach var="dept" items="${listDept}">
                                        <option value="${dept.id}">>
                                                ${dept.deptName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button id="modify-button" type="submit" class="btn btn-primary btn-block btn-flat">提交</button>
                    </form>
                    <!--<button id="reset" type="reset" class="btn btn-primary btn-block btn-flat">重置信息</button>-->
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
<script src="/assets/js/userModify.js"></script>
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
