package com.group.ctms.service.impl;

import com.group.ctms.dao.AuthorityMapper;
import com.group.ctms.dao.EmployeeMapper;
import com.group.ctms.dao.RoleMapper;
import com.group.ctms.entity.Authority;
import com.group.ctms.entity.Employee;
import com.group.ctms.entity.Role;
import com.group.ctms.service.IAuthorityService;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 权限服务具体实现
 */
@Service
public class AuthorityServiceImpl implements IAuthorityService {
    private AuthorityMapper authorityMapper;
    private EmployeeMapper employeeMapper;
    private RoleMapper roleMapper;

    @Autowired
    public AuthorityServiceImpl(AuthorityMapper authorityMapper, EmployeeMapper employeeMapper,
                                RoleMapper roleMapper){
        this.authorityMapper = authorityMapper;
        this.employeeMapper = employeeMapper;
        this.roleMapper = roleMapper;
    }

    public Result addApprover(Authority authority) {
        Result result = new Result();
        //根据工号获得employee对象
        Employee employee = employeeMapper.findEmployeeByNum(authority.getUserId());
        Role role;
        //判断员工是否存在
        if (employee == null){
            result.setMessage("该员工不存在");
            return result;
        } else {
            role = roleMapper.getRoleById(employee.getRoleId());
        }
        if (role.getRoleNum() == 1){
            result.setMessage("审批者角色不能是普通员工");
            return result;
        } else {
            authority.setUserId(employee.getId());
            //设置审批者的姓名
            authority.setUsername(employee.getEmployeeName());
            //设置审批者的角色id
            authority.setUserRoleId(role.getId());
            //默认是未删除
            authority.setDeletedMark(0);
            if (authorityMapper.addApprover(authority)){
                result.setMessage("添加成功");
            } else {
                result.setMessage("添加出错");
            }
        }

        return result;
    }

    public boolean deleteApprover(Integer id) {
        return authorityMapper.deleteApprover(id);
    }

    public List<Authority> listAllAuthority() {
        return authorityMapper.listAllAuthority();
    }

    /**
     * 通过审批权限记录的id查找一位审批者
     *
     * @param id 记录id
     * @return 返回一个审批者记录
     */
    @Override
    public Authority findApproverById(Integer id) {
        return authorityMapper.findApproverById(id);
    }

    /**
     * 根据权限表中的用户的id查找一条审批者记录
     * @param id 用户的id
     * @return 返回一个审批者
     */
    @Override
    public Authority findApproverByUserId(Integer id){
        return authorityMapper.findApproverByUserId(id);
    }
}
