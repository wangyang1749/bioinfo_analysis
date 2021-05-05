package com.wangyang.bioinfo;

import com.wangyang.bioinfo.pojo.Role;
import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.service.IRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@SpringBootTest
public class TestRole {
    @Autowired
    IRoleService roleService;

    @Test
    public void testAdd(){
        Role role = new Role();
        role.setName("白醋");
        roleService.addRole(role);
    }
    @Test
    public void testAdd_user(){
        Role role = new Role();
        User user =new User();
        user.setId(10);
        Set<User> users = new HashSet<>();
        users.add(user);
        role.setUsers(users);
        role.setName("白醋");
        roleService.addRole(role);
    }
    @Test
    public void testDel(){
        roleService.delRole(3);
    }

    @Test
    public void testPage(){
        Page<Role> roles = roleService.pageRole(PageRequest.of(0, 5));
        System.out.println(roles);
    }
}
