package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.repository.UserRepository;
import com.wangyang.bioinfo.service.IUserService;
import com.wangyang.bioinfo.util.BioinfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return  userOptional.isPresent()?userOptional.get():null;
    }

    @Override
    public User delUser(int id) {
        User user = findUserById(id);
        if(user==null){
            throw new BioinfoException("需要删除的用户不存在!!");
        }
        userRepository.delete(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public Page<User> pageUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
