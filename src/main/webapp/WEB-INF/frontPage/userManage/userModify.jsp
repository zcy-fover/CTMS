<%--
  Created by IntelliJ IDEA.
  User: Chirs
  Date: 2016/11/15
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userModify</title>
    <link rel="stylesheet" href="../../../assets/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="../../../assets/css/modify.css">
    <link rel="stylesheet" href="../../../assets/css/bootstrapValidator.min.css" />
</head>
<body>
<div class="modify">
    <div class="modify-box-msg">
        <p>用户信息修改</p>
    </div>
    <div class="modify-box-body">
        <form id="modify-form" action="modify" method="post">
            <label class="col-sm-2 control-label">员工工号</label>
            <div class="col-lg-10">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" name="employee_num" placeholder="员工工号" value="${XXXXXXXXXXXXXXX}" readonly="readonly">
                    <span class="fa fa-user form-control-feedback"></span>
                </div>
            </div>
            <label class="col-sm-2 control-label">员工姓名</label>
            <div class="col-lg-10">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" name="employee_name" placeholder="姓名" value="${XXXXXXXXXXXXXXX}">
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
                        <option value="1">Java Web</option>
                        <option value="2">Java Network</option>
                    </select>
                </div>
            </div>
        </form>
        <button id="modify-button" type="submit" class="btn btn-primary btn-block btn-flat">修改</button>
    </div>
</div>

<script src="../../../assets/js/base/jquery-2.2.3.min.js"></script>
<script src="../../../assets/js/base/bootstrap.min.js"></script>
<script src="../../../assets/js/bootstrapValidator.min.js" ></script>
<script src="../../../assets/js/userModify.js"></script>
</body>
</html>
