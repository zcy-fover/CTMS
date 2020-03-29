package com.group.ctms.service.impl;

import com.group.ctms.dao.RoleMapper;
import com.group.ctms.entity.Role;
import com.group.ctms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * Completed by Doctor Who on 2016/11/16
 * 角色服务具体实现
 */
//@SuppressWarnings("unused")
@Service
public class RoleServiceImpl implements IRoleService{
    private RoleMapper roleMapper;
    
    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper){
        this.roleMapper = roleMapper;
    }

    public boolean addRole(Role role) {
        return roleMapper.addRole(role);
    }

    public boolean deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }

    public boolean reviseRole(Role role) {
        return roleMapper.reviseRole(role);
    }

    public Role getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }

    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }
}
