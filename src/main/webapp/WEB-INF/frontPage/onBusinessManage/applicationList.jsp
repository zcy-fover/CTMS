<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="../common/common-css.jsp"%>
    <link rel="stylesheet" href="/assets/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="/assets/css/applicationList.css">

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
            <div class="container-fluid container-style" style="margin-bottom: 0px">
                <form id="query-form" action="/application/query" method="post" class="form-horizontal">
                    <input id="pageNum" name="pageNum" value="${page.pageNum}" hidden="hidden">
                    <input id="pageSize" name="pageSize" value="${page.pageSize}" hidden="hidden">
                    <div class="col-lg-3">
                        <div class="form-group has-feedback">
                            <label class="col-sm-4 control-label">开始时间</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" name="startDate" id="startDate" data-date-format="yyyy-mm-dd">
                                <span class="add-on"><i class="icon-th"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group has-feedback">
                            <label class="col-sm-4 control-label">结束时间</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" name="endDate"  id="endDate" data-date-format="yyyy-mm-dd">
                                <span class="add-on"><i class="icon-th"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <select id="choose_state" class="form-control" name="checkState">
                            <option value="">请选择</option>
                            <option value="10">待部门经理审核</option>
                            <option value="20">待财务经理审核</option>
                            <option value="30">待行政经理审核</option>
                            <option value="100">通过</option>
                        </select>
                    </div>
                    <div class="col-lg-1">
                        <button id="query-button" type="submit" class="btn btn-primary btn-block btn-flat">查询</button>
                    </div>
                    <div class="col-lg-1" >
                        <button class="btn  btn-primary btn-block btn-flat" type="button" data-toggle="modal" onclick="commit()">申请</button>
                    </div>
                </form>
            </div>

            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table" style="text-align: left">
                            <thead>
                            <tr>
                                <td>申请号</td>
                                <td>姓名</td>
                                <td>开始时间</td>
                                <td>结束时间</td>
                                <td>出差地点</td>
                                <td>交通费</td>
                                <td>住宿费</td>
                                <td style="text-align: center">审批状态</td>
                                <td style="text-align: center">操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.list}" var="application">
                                <tr>
                                    <td>${application.id}</td>
                                    <td>${application.employeeName}</td>
                                    <td>
                                        <fmt:formatDate value="${application.startDate}" dateStyle="default"/>
                                    </td>
                                    <td><fmt:formatDate value="${application.endDate}" dateStyle="default"/>
                                    </td>
                                    <td>${application.destination}</td>
                                    <td>${application.trafficFee}</td>
                                    <td>${application.accomodation}</td>
                                    <td style="text-align: center">
                                        <c:choose>
                                            <c:when test="${application.checkState == '10'}">
                                                待部门经理审批
                                            </c:when>
                                            <c:when test="${application.checkState == '20'}">
                                                待财务经理审批
                                            </c:when>
                                            <c:when test="${application.checkState == '30'}">
                                                待行政经理审批
                                            </c:when>
                                            <c:when test="${application.checkState == '-1'}">
                                                不通过
                                            </c:when>
                                            <c:otherwise>
                                                通过
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class=" mybtn-style btn btn-primary btn-flat" href="/application/detail?id=${application.id}">详情</a>
                                        <c:if test="${application.checkState != '100'}">
                                            <button class=" btn btn-warning btn-flat" type="button" data-toggle="modal" onclick="update('${application.id}')">修改</button>
                                            <a class=" btn btn-danger btn-flat" href="/application/delete?id=${application.id}&pageNum=${page.pageNum}&pageSize=${page.pageSize}">删除</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="pagination pagination-large" style="margin-left: 360px; margin-top: 0px; margin-bottom: 0px;">
                            <%@ include file="../common/page.jsp"%>
                        </div>
                    </div>
                </div>
            </div>


            <%--模态框开始--%>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" style="margin-top: 150px;width: 40%">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        </div>
                        <div class="modal-body" id="modal-body-id">

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!--此处引入脚-->
    <%@ include file="../common/foot.jsp"%>
</div>
<%@include file="../common/common-js.jsp"%>
<script src="${basePath}/assets/js/bootstrap-datetimepicker.min.js"></script>
<script src="/assets/js/query.js"></script>
<script>
    function commit() {
//        alert("fkjsdhfjk");
        $('#myModal').modal('show');
        $('#modal-body-id').load('/application/toAdd?pageNum=${page.pageNum}&pageSize=${page.pageSize}');

    }
//
    function update(id) {
        var url = '/application/toUpdate?id=' + id +'&pageNum=${page.pageNum}&pageSize=${page.pageSize}';
//        alert(url);
        $('#myModal').modal('show');
        $('#modal-body-id').load(url);
    }

</script>
</body>
</html>