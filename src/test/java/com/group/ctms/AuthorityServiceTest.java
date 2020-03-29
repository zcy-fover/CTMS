package com.group.ctms;

import com.group.ctms.entity.Authority;
import com.group.ctms.service.IAuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Doctor Who on 2016/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
                                  "classpath:/spring/springMVC-config.xml"})
public class AuthorityServiceTest {
    @Autowired
    private IAuthorityService authorityService ;

//    @Test
//    public void add(){
//        Authority authority = new Authority();
//        authority.setUserId(1);
//        authority.setApprovalOrder(1);
//        authority.setApprovalState(10);
//        if (authorityService.addApprover(authority)){
//            System.out.println("**successful**");
//        }else {
//            System.out.println("##unsuccessful##");
//        }
//    }

    @Test
    public void delete(){
        if (authorityService.deleteApprover(1)){
            System.out.println("删除成功");
        }
    }

    @Test
    public void list(){
        List<Authority> authorities = authorityService.listAllAuthority();
        for (Authority a:authorities
             ) {
            System.out.println(a.toString());
        }
    }
}
