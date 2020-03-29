package com.group.ctms;

import com.group.ctms.entity.Role;
import com.group.ctms.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Doctor Who on 2016/11/16.
 * 角色服务测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-mybatis.xml",
        "classpath:/spring/springMVC-config.xml"})
public class RoleServiceTest {
    @Autowired
    private IRoleService roleService;

    @Test
    public void add(){
        Role role = new Role();
        role.setRoleName("财务经理");
        role.setRoleNum(1);
        role.setRoleDesc("nothing to say");
        role.setDeletedMark(0);
        if (roleService.addRole(role)){
            System.out.println("**successful**");
        }else {
            System.out.println("**unsuccessful**");
        }
    }

    @Test
    public void delete(){
        if (roleService.deleteRole(1)){
            System.out.println("**successful");
        }else{
            System.out.println("**unsuccessful**");
        }
    }

    @Test
    public void revise(){
        Role role = roleService.getRoleById(1);
        role.setRoleDesc("awesome");
        if (roleService.reviseRole(role)){
            System.out.println("*******");
        }else{
            System.out.println("#######");
        }
    }
}
