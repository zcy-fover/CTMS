package com.group.ctms.dao;

import com.group.ctms.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/15.
 * 部门mapper映射文件
 */
@SuppressWarnings("unused")
@Repository
public interface DepartmentMapper {
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
