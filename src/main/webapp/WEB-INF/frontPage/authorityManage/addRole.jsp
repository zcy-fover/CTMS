<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<div class="role-box-body">
    <form id="role-form" action="/role/save" method="post" class="form-horizontal">
        <div class="form-group has-feedback">
            <label class="col-sm-3 control-label">角色名</label>
            <div class="col-lg-9">
                <input type="text" class="form-control" name="roleName" placeholder="角色名">
                <span class="fa fa-user form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-feedback">
            <label class="col-sm-3 control-label">角色编号</label>
            <div class="col-lg-9">
                <input type="text" class="form-control" name="roleNum" placeholder="角色编号">
                <span class="fa fa-user form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-feedback">
            <label class="col-sm-3 control-label">角色描述</label>
            <div class="col-lg-9">
                <input type="text" class="form-control" name="roleDesc" placeholder="角色描述">
                <span class="fa fa-user form-control-feedback"></span>
            </div>
        </div>
        <button id="role-button" type="submit" class="btn btn-primary btn-block btn-flat">提交</button>
    </form>
</div>
