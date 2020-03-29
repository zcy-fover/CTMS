package com.group.ctms.dao;

import com.group.ctms.entity.Application;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * Completed by Doctor Who on 2016/11/14
 * 申请单映射数据库文件
 */
//@SuppressWarnings("unused")
@Repository
public interface ApplicationMapper {
    /**
     * 添加申请表
     * @param application 提交的申请表
     * @return
     */
    public boolean addApplication(Application application);

    /**
     * 删除申请表（逻辑）
     * @param id
     * @return
     */
    public boolean delApplication(Integer id);

    /**
     * 修改申请表
     * @param application
     * @return
     */
    public boolean reviseApplication(Application application);

    /**
     * 查询符合条件的表单
     * @param application 通过application中的startDate和endDate属性或者check_state属性作为条件查询
     * @return 返回符合条件的Application集合
     */
    public List<Application> queryApplication(Application application);

    /**
     * 显示当前用户所有未删除申请单
     * @param employeeNum
     * @return
     */
    public List<Application> listApplication(Integer employeeNum);

    /**
     * 根据ID查询申请表
     * @param id
     * @return
     */
    public Application getApplicationById(Integer id);
}
