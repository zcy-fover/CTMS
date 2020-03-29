package com.group.ctms;

import com.group.ctms.service.ICheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zcy-fover on 2016/11/16.
 * 审核申请测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
        "classpath:/spring/springMVC-config.xml"})
@SuppressWarnings("unused")
public class CheckServiceTest {
    @Autowired
    private ICheckService checkService;

    @Test
    public void checkAppTest(){

    }

}
