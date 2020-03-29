<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="../common/common-css.jsp"%>
    <link rel="stylesheet" href="/assets/css/applicationSubmit.css">
</head>
<body class="hold-transition fix skin-blue sidebar-mini">

    <div class="wrapper">
        <!--此处引入左边菜单和头文件-->
        <%@ include file="../common/header-left.jsp"%>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <section class="content-header">
                <h4>
                    <a href="${basePath}/toHome">首页</a>-><a href="/check/checkList">申请单列表</a>
                </h4>
            </section>

            <!-- 添加页面主要内容 -->
            <section class="content">
                <div class="application-box-msg">
                    <p>员工出差申请详情</p>
                </div>
                <div class="application-box-body">
                    <form id="application-form" action="application" method="post" class="form-horizontal" style="width: 600px; margin-left: -100px;">
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">申请单号</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="id" value="${application.id}" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">工号</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="employeeNum" value="${application.employeeNum}" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">姓名</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="employeeName" value="${application.employeeName}" readonly="readonly">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">部门</label>
                                <div class="col-lg-8">
                                    <select name="deptId" class="form-control" readonly="readonly">
                                        <c:forEach var="dept" items="${listDept}">
                                            <option value="${dept.id}" <c:if test="${application.deptId == dept.id}">selected</c:if>>${dept.deptName}</option>
                                        </c:forEach>
                                    </select>
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <row>
                            <div class="col-lg-6">
                                <div class="form-group has-feedback">
                                    <label class="col-sm-4 control-label">开始时间</label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" name="startDate" readonly="readonly" value="<fmt:formatDate value="${application.startDate}" dateStyle="default"/>">
                                        <span class="add-on"><i class="icon-th"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group has-feedback">
                                    <label class="col-sm-4 control-label">结束时间</label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" name="endDate" readonly="readonly" value="<fmt:formatDate value="${application.endDate}" dateStyle="default"/>">
                                        <span class="add-on"><i class="icon-th"></i></span>
                                    </div>
                                </div>
                            </div>
                        </row>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">出差地点</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="destination" readonly="readonly" value="${application.destination}">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">交通工具</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="vehicle" readonly="readonly" value="${application.vehicle}">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">交通费</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="trafficFee" readonly="readonly" value="${application.trafficFee}">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label class="col-sm-4 control-label">住宿费</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" name="accomodation"  readonly="readonly" value="${application.accomodation}">
                                    <span class="fa fa-user form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-sm-2 control-label">出差<br/>事由</label>
                            <div class="col-lg-10">
                                <textarea type="text" class="form-control" name="reason" placeholder="出差事由" readonly="readonly">
                                    ${application.reason}
                                </textarea>
                                <span class="fa fa-user form-control-feedback"></span>
                            </div>
                        </div>
                    </form>
                    <div class="col-lg-6">
                        <a id="success" href="/check/checkApp?id=${application.id}&checkState=${application.checkState}" class="btn btn-success btn-block btn-flat">通过申请</a>
                    </div>
                    <div class="col-lg-6"><%-- onclick="reject()"--%>
                        <button class="btn  btn-danger btn-block btn-flat" data-toggle="modal" data-target="#myModal">拒绝申请</button>
                    </div>
                </div>

                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="margin-top: 150px;width: 30%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel" >
                                    请填写拒绝理由
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form action="/check/checkApp" method="post">
                                    <input name="id" hidden="hidden" value="${application.id}">
                                    <input name="checkState" hidden="hidden" value="-1">
                                    <input type="text" class="form-control" name="auditFeedback"  placeholder="理由">

                                    <div class="modal-footer" style="text-align: center; margin-top: 20px; margin-bottom: -20px;">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        <button type="submit" class="btn btn-primary">提交理由</button>
                                    </div>
                                </form>
                            </div>
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
//        function reject() {
//            $.('#myModal').modal({
//                keyboard: true
//            });
//        }

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
