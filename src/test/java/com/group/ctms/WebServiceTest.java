package com.group.ctms;

import com.group.ctms.service.IWebService;
import com.group.ctms.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zcy-fover on 2016/11/11.
 * web服务方法测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
        "classpath:/spring/springMVC-config.xml"})
public class WebServiceTest {
    @Autowired
    private IWebService webService;

    @Test
    public void testFindEmployeeByNum(){
        Result result;
        new Result();
        result = webService.findEmployeeByNum(2001, "123456");
        System.out.println(result.getMessage());
    }

}
