package com.group.ctms.service.impl;

import com.group.ctms.dao.EmployeeMapper;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IWebService;
import com.group.ctms.util.MD5;
import com.group.ctms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zcy-fover on 2016/11/10.
 * web服务的具体实现
 */
@SuppressWarnings("unused")
@Service
public class WebServiceImpl implements IWebService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 根据员工工号和密码查询员工
     *
     * @param employeeNum 员工工号
     * @param password    密码
     * @return 返回一个员工对象
     */
    @Override
    public Result findEmployeeByNum(int employeeNum, String password) {

        Result result = new Result();

        Employee employee = employeeMapper.findEmployeeByNum(employeeNum);
        result.setSuccess(false);
        if (employee == null) {
            result.setMessage("该员工不存在");
            return result;
        } else if (!password.equals(employee.getPassword())) {
            result.setMessage("密码错误");
            return result;
        } else {
            result.setMessage("登录成功");
            result.setSuccess(true);
            return result;
        }
    }
}
