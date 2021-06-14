package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.pojo.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface IUserService {
    User addUser(User user);
    User delUser(int id);
    User findUserById(int id);
    List<User> findAllById(Collection<Integer> id);
    List<UserDto> listAll();
    Page<User> pageUser(Pageable pageable);
    User updateUser(User user);
    User login(String username,String password);
    User findUserByUsername(String username);
    // ---------------------------------------
}
