<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>公司差旅管理系统</title>
    <link rel="icon" href="/assets/img/logo-32.ico"/>
    <%@ include file="common/common-css.jsp"%>
</head>
<body class="hold-transition fix skin-blue sidebar-mini">
    <div class="wrapper">
        <!--此处引入左边菜单和头文件-->
        <%@ include file="common/header-left.jsp"%>
    
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <%--<section class="content-header">--%>
                <%--<h1>--%>
                    <%--Page Header--%>
                    <%--<small>Optional description</small>--%>
                <%--</h1>--%>
                <%--<ol class="breadcrumb">--%>
                    <%--<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>--%>
                    <%--<li class="active">Here</li>--%>
                <%--</ol>--%>
            <%--</section>--%>
    
            <!-- 添加页面主要内容 -->
            <section class="content">
                <div class="blank">
                    <div class="logo" style="margin: 10% 40% 0">
                        <img src="/assets/img/blank-logo.png" width="200" height="250" style="padding-bottom: 50px">
                        <h2 style="width: 300px; margin-left: -40px;">欢迎使用公司差旅系统</h2>
                    </div>
                </div>
            </section>
            <!-- /.content -->
        </div>
    
        <!--此处引入脚-->
        <%@ include file="common/foot.jsp"%>
    </div>
    
    <%--引入js文件--%>
    <%@ include file="common/common-js.jsp"%>

    <%--引入消息弹框--%>
    <%@ include file="common/message.jsp"%>
</body>
</html>
