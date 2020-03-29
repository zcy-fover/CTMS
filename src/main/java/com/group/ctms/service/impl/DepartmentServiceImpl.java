package com.group.ctms.service.impl;

import com.group.ctms.dao.DepartmentMapper;
import com.group.ctms.entity.Department;
import com.group.ctms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/15.
 * department的服务方法实现
 */
@SuppressWarnings("unused")
@Service
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 通过id查询部门
     *
     * @param id 传入的参数id
     * @return 返回一条部门记录
     */
    @Override
    public Department getDeptById(int id) {
        return departmentMapper.getDeptById(id);
    }

    /**
     * 查询所有部门
     *
     * @return 返回部门的list集
     */
    @Override
    public List<Department> getAllDept() {
        return departmentMapper.getAllDept();
    }
}
