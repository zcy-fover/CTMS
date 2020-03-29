<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <title>登录</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="common/common-css.jsp"%>
    <link rel="stylesheet" href="/assets/css/login.css">

</head>
<body class="hold-transition login-page bodyBack">
    <div class="twins">
        <div class="login-logo">
            <b>公司差旅管理系统</b>
        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
            <p class="login-box-msg"><strong>用户登录</strong></p>

            <form id="login-form" name="login-form" action="/login" method="post">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" name="employeeNum" placeholder="员工工号">
                    <i class="fa fa-user form-control-feedback"></i>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" name="password" placeholder="密码">
                    <span class="fa fa-lock form-control-feedback"></span>
                </div>
                <!--<div class="four-row">-->
                <!--<input type="checkbox" name="remember"> 记住我-->
                <!--<a href="forget">忘记密码？</a>-->
                <!--</div>-->
                <button id="login-button" type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
            </form>


            <div class="six-row">
                <a href="javascript:void(0)" onclick="registerView()" class="text-center">还没有账户，马上注册吧</a>
            </div>
        </div>
        <!-- /.login-box-body -->

        <!--register-begin-->
        <div class="register-box-body" style="display: none;">
            <p class="login-box-msg">用户注册</p>
            <form id="register-form" name="register-form" action="/register" method="post">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" name="employeeNum" placeholder="员工工号">
                    <span class="fa fa-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" name="employeeName" placeholder="姓名">
                    <span class="fa fa-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" name="password" placeholder="密码">
                    <span class="fa fa-lock form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" name="retypePassword" placeholder="重新输入密码">
                    <span class="fa fa-lock form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <select name="deptId" class="form-control">
                        <option value="" style="display: none;">归属部门</option>
                        <c:forEach var="dept" items="${listDept}">
                            <option value="${dept.id}">${dept.deptName}</option>
                        </c:forEach>
                    </select>
                </div>
                <button id="register-button" type="submit" class="btn btn-primary btn-block btn-flat">马上注册</button>
            </form>

            <div class="six-row">
                <a href="javascript:void(0)" onclick="loginView()" class="text-center">已经拥有账户，马上登录</a>
            </div>
        </div>
        <!--register-end-->
    </div>
    <!-- /.login-box -->

    <!-- iCheck -->
    <%@ include file="common/common-js.jsp"%>
    <script src="/assets/js/login.js"></script>

    <%@ include file="common/message.jsp"%>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#register-form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    employeeNum: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '员工工号不能为空'
                            },
                            stringLength: {
                                min: 3,
                                max: 6,
                                message: '员工工号大于3位小于6位'
                            },
                            numeric: {
                                message: '员工工号只能输入数字'
                            },
//                            remote: {
//                                url: '/register',
//                                message: 'The username is not available'
//                            },
                            different: {
                                field: 'password',
                                message: '员工工号不能与密码一致'
                            }
                        }
                    },
                    employeeName: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '员工姓名不能为空'
                            }
//                            remote: {
//                                url: '/register',
//                                message: 'The username is not available'
//                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            different: {
                                field: 'employeeNum',
                                message: '密码与员工工号不能一致'
                            }
                        }
                    },
                    retypePassword: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            identical: {
                                field: 'password',
                                message: '与输入密码不一致'
                            }
                        }
                    }
                }
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#login-form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    employeeNum: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '员工工号不能为空'
                            },
                            stringLength: {
                                min: 3,
                                max: 6,
                                message: '员工工号大于3位小于6位'
                            },
                            numeric: {
                                message: '员工工号只能输入数字'
                            },
                            different: {
                                field: 'password',
                                message: '员工工号不能与密码一致'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    }
                }
            });
        });
    </script>
</body>
</html>
