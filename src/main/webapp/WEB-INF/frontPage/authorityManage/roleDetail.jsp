<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="../common/common-css.jsp"%>
    <link rel="stylesheet" href="/assets/css/role.css">
</head>
<body class="hold-transition fix skin-blue sidebar-mini">

<div class="wrapper">

    <!--此处引入左边菜单和头文件-->
    <%@ include file="../common/header-left.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h4>
                <a href="${basePath}/toHome">首页</a>-><a href="${basePath}/role/list">角色列表</a>
            </h4>
        </section>

        <!-- 添加页面主要内容 -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="container-fluid container-style">
                    <div class="col-lg-2" >
                        <button class="btn  btn-primary btn-block btn-flat" type="button" data-toggle="modal" onclick="save()">申请</button>
                    </div>
            </div>

            <div class="container-fluid" style="width: 800px; margin-left: 0px;">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table" style="text-align: center">
                            <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>角色名</td>
                                    <td>角色编号</td>
                                    <td>角色描述</td>
                                    <td>操作</td>
                                    <td>操作</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${roles}" var="role">
                                    <tr>
                                        <td>${role.id}</td>
                                        <td>${role.roleName}</td>
                                        <td>${role.roleNum}</td>
                                        <td>${role.roleDesc}</td>
                                        <td>
                                            <button class="mybtn-style btn btn-primary btn-block btn-flat" type="button" data-toggle="modal" onclick="updateRole('${role.id}')">修改</button>
                                        </td>
                                        <td><a class="mybtn-style btn btn-danger btn-block btn-flat" href="/role/delete?id=${role.id}">删除</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


            <%--模态框开始--%>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" style="margin-top: 150px;width: 30%">
                    <div class="modal-content">
                        <div class="modal-header" style="padding-bottom: 30px">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        </div>
                        <div class="role-modal-body" id="role-modal-body-id">

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
<script>
    function updateRole(id) {
        var url = '/role/toEdit?id=' + id;
        $('#roleModal').modal('show');
        $('#role-modal-body-id').load(url);
    }

    function save() {
        $('#roleModal').modal('show');
        $('#role-modal-body-id').load('/role/toEdit');
    }
</script>
</body>
</html>
