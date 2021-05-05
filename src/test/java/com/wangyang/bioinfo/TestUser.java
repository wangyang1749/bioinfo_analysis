package com.wangyang.bioinfo;

import com.wangyang.bioinfo.pojo.Role;
import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.service.IRoleService;
import com.wangyang.bioinfo.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.AnnotationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@SpringBootTest
//@Transactional
public class TestUser {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;

    User user_g;
    @Test
    public void testAdd(){
        User user = new User();
        user.setUsername("zhangSan");
        user.setEmail("1749748955@qq.com");
        user.setGender(0);
        user.setPassword("123456");
        user_g = userService.addUser(user);
    };
    @Test
    public void testAddUser_Role(){
        User user = new User();
        user.setUsername("zhangSan");
        user.setEmail("1749748955@qq.com");
        user.setGender(0);
        user.setPassword("123456");
//        Role role = new Role();
//        role.setName("Admin");
//        Set<Role> roles  =new HashSet<>();
//        roles.add(role);
//        user.setRoles(roles);
        Role role = new Role();
        role.setId(3);
        Set<Role> roles  =new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user_g = userService.addUser(user);
    }
    @Test
    public void testAddUser_find_Role(){
        User user = new User();
        user.setUsername("zhangSan");
        user.setEmail("1749748955@qq.com");
        user.setGender(0);
        user.setPassword("123456");
        Role role = new Role();
        role.setId(3);
        Set<Role> roles  =new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user_g = userService.addUser(user);
    };

    @Test
    public void testFind(){
//        testAdd();
//        int id = user_g.getId();
        User user = userService.findUserById(20);
        System.out.println(user.getRoles());
    }
    @Test
    public void testDel(){
        User user = userService.delUser(20);
        System.out.println(user);
//        User user1 = userService.delUser(50);
    }

    @Test
    public void testPage(){
        Page<User> users = userService.pageUser(PageRequest.of(0, 6));
        System.out.println(users);
    }
}
