package com.group.ctms;

import com.group.ctms.entity.Application;
import com.group.ctms.entity.AuditLog;
import com.group.ctms.entity.Employee;
import com.group.ctms.service.IApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Doctor Who on 2016/11/15.
 * 申请表服务测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
                                   "classpath:/spring/springMVC-config.xml"})
public class ApplicationServiceTest {
    @Autowired
    private IApplicationService applicationService;

    @Test
    public void add(){
        Application app =new Application();
        Employee employee = new Employee();
        AuditLog auditLog = new AuditLog();
        employee.setId(1);
        employee.setEmployeeName("david");
        app.setEmployeeNum(1);
        app.setDeptId(2);
        app.setTrafficFee(234.3);
        app.setDeletedMark(0);
        app.setCheckState(0);
        app.setEmployeeName("david");
        app.setReason("conference");
        app.setAccomodation(345.3);
        app.setDestination("北京");
        app.setVehicle("train");
        app.setStartDate(new Date());
        app.setEndDate(new Date());
        if (applicationService.addApplication(1,app)){
            System.out.println("add successfully");
            auditLog.setApplicationId(app.getId());
            auditLog.setUserId(employee.getId());
            auditLog.setUsername(employee.getEmployeeName());
            auditLog.setAuditType(1);
            if (applicationService.addAuditLog(app,auditLog)){
                System.out.println("add audit successfully");
            }
        }else{
            System.out.println("add unsuccessfully");
        }
    }

    @Test
    public void revise(){
        Application application = new Application();
        application.setId(2);
        application.setStartDate(new Date());
        application.setEndDate(new Date());
        application.setDestination("wuhan");
        if (applicationService.reviseApplication(application)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void delete(){
        if (applicationService.delApplication(3)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void list(){
        Integer id = 1001;
        List<Application> list = applicationService.listApplication(1001);
        if (list != null){
            for (Application application: list
                 ) {
                System.out.println(application.toString());
            }
        }
        Date nowDate = new Date();
        System.out.println(nowDate);
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void query(){
        Application app = new Application();
        app.setStartDate(new Date()); //2016-12-1
        app.setEndDate(new Date());  //2016-12-30
        app.setCheckState(20);
        List<Application> list = applicationService.queryApplication(app);
        if (list != null){
            for (Application application: list) {
                System.out.println(application.toString());
            }
        }else {
            System.out.println("查询记录为空");
        }
    }
}

