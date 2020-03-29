package com.group.ctms.service;

import com.group.ctms.util.Result;

/**
 * Created by zcy-fover on 2016/11/10.
 * web主服务接口
 */
@SuppressWarnings("unused")
public interface IWebService {
    /**
     * 根据员工工号和密码查询员工
     * @param employeeNum 员工工号
     * @param password 密码
     * @return 返回一个员工对象
     */
    Result findEmployeeByNum(int employeeNum, String password);
}
