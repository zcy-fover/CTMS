<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>公司差旅管理系统</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" data-toggle="offcanvas" role="button">
            <img src="/assets/img/list.png" style="padding-top: 10px;padding-left: 10px;">
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- 导航栏 - Message -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="../../assets/img/head/head0.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">${sessionScope.user.employeeName}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="../../assets/img/head/head0.jpg" class="img-circle" alt="User Image">

                            <p>
                                ${sessionScope.user.employeeName}
                                <small class="status"></small>
                                <small></small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">个人设置</a>
                            </div>
                            <div class="pull-right">
                                <a href="/logOut" class="btn btn-default btn-flat">退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../../assets/img/head/head0.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.user.employeeName}</p>
            </div>
        </div>
        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/employee/toEdit?id=${sessionScope.user.id}">个人信息</a></li>
                    <c:if test="${sessionScope.userRole.roleNum > 0}">
                        <li><a href="/employee/list?pageNum=1&pageSize=8">用户列表</a></li>
                    </c:if>
                </ul>
            </li>
            <c:if test="${sessionScope.userRole.roleNum > 0}">
                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>权限管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/role/list">角色管理</a></li>
                        <c:if test="${sessionScope.userRole.roleNum == 100}">
                            <li><a href="/authority/list">审批权限</a></li>
                        </c:if>
                    </ul>
                </li>
            </c:if>

            <li class="treeview">
                <a href="/application/queryAll?pageNum=1&pageSize=8"><i class="fa fa-link"></i> <span>出差申请</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <%--<ul class="treeview-menu">--%>
                    <%--<li><a href="#">提交申请</a></li>--%>
                <%--</ul>--%>
            </li>
            <c:if test="${sessionScope.userRole.roleNum == 10}">
                <li class="treeview">
                    <a href="/check/checkList"><i class="fa fa-link"></i> <span>申请审批</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <%--<ul class="treeview-menu">--%>
                        <%--<li><a href="#">部门审批</a></li>--%>
                        <%--<li><a href="#">流程跟踪</a></li>--%>
                    <%--</ul>--%>
                </li>
            </c:if>
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>统计报表</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
