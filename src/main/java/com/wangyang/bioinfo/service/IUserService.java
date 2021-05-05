package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface IUserService {
    User addUser(User user);
    User delUser(int id);
    User findUserById(int id);
    User updateUser(User user);
    Page<User> pageUser(Pageable pageable);
}
