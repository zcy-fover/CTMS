package com.group.ctms.service;

import com.group.ctms.entity.Department;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/15.
 * 部门服务接口
 */
@SuppressWarnings("unused")
public interface IDepartmentService {

    /**
     * 通过id查询部门
     * @param id 传入的参数id
     * @return 返回一条部门记录
     */
    Department getDeptById(int id);

    /**
     * 查询所有部门
     * @return 返回部门的list集
     */
    List<Department> getAllDept();
}
