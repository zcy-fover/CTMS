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
                <!-- Your Page Content Here -->
                <div class="container-fluid container-style" style="margin-bottom: 20px">
                    <div class="col-lg-2" >
                        <button class="btn btn-primary btn-block btn-flat" type="button" data-toggle="modal" data-target="#myModal">添加审批者</button>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row-fluid">
                        <div class="span6">
                            <table class="table" style="width: 800px">
                                <thead style="text-align: center;">
                                    <tr>
                                        <td>ID</td>
                                        <td>姓名</td>
                                        <td>角色</td>
                                        <td>审批顺序</td>
                                        <td>状态码</td>
                                        <td>操作</td>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center;">
                                    <c:forEach var="authority" items="${authorityList}">
                                        <tr>
                                            <td>${authority.id}</td>
                                            <td>${authority.username}</td>
                                            <td>
                                                <c:forEach var="role" items="${listRole}">
                                                    <c:if test="${authority.userRoleId == role.id}">
                                                        ${role.roleName}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>${authority.approvalOrder}</td>
                                            <td>${authority.approvalState}</td>
                                            <td>
                                                <a class="btn btn-danger btn-block btn-flat" href="/authority/delete?id=${authority.id}">删除</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <%--模态框开始--%>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="margin-top: 150px;width: 30%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel" >
                                    添加审批者
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div style="height: 200px; border-radius: 5px;">
                                    <form action="/authority/add" method="post">
                                        <label class="col-sm-4 control-label">员工工号</label>
                                        <div class="col-lg-8">
                                            <div class="form-group has-feedback">
                                                <input type="text" class="form-control" name="userId" placeholder="工号">
                                                <span class="fa fa-user form-control-feedback"></span>
                                            </div>
                                        </div>

                                        <label class="col-sm-4 control-label">审批顺序</label>
                                        <div class="col-lg-8">
                                            <div class="form-group has-feedback">
                                                <input type="text" class="form-control" name="approvalOrder" placeholder="审批顺序">
                                                <span class="fa fa-user form-control-feedback"></span>
                                            </div>
                                        </div>

                                        <label class="col-sm-4 control-label">审批状态码</label>
                                        <div class="col-lg-8">
                                            <div class="form-group has-feedback">
                                                <input type="text" class="form-control" name="approvalState" placeholder="审批状态码">
                                                <span class="fa fa-user form-control-feedback"></span>
                                            </div>
                                        </div>

                                        <label class="col-sm-2 control-label"></label>
                                        <div class="col-lg-3">
                                            <div class="form-group has-feedback">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-lg-offset-1">
                                            <button type="submit" class="btn btn-primary">提交</button>
                                        </div>
                                    </form>
                                </div>
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
    <%@ include file="../common/message.jsp"%>
</body>
</html>
