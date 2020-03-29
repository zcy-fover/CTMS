package com.group.ctms.dao;

import com.group.ctms.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 角色的mapper文件，影射数据库操作
 */
//@SuppressWarnings("unused")
@Repository
public interface RoleMapper {
    /**
     * 添加角色
     * @param role
     * @return
     */
    public boolean addRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    public boolean deleteRole(Integer id);

    /**
     * 修改角色
     * @param role
     * @return
     */
    public boolean reviseRole(Role role);

    /**
     * 根据ID查询角色
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
