package com.group.ctms.service;

import com.group.ctms.entity.Role;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 */
@SuppressWarnings("unused")
public interface IRoleService {
    /**
     * 添加角色
     * @param role 角色实体
     * @return
     */
    public boolean addRole(Role role);
    /**
     * 删除角色
     * @param id 角色Id
     * @return
     */
    public boolean deleteRole(Integer id);
    /**
     * 修改角色
     * @param role 角色实体
     * @return
     */
    public boolean reviseRole(Role role);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Role getRoleById(Integer id);

    /**
     * 查询并显示所有角色
     * @return
     */
    public List<Role> getAllRole();
}
