package com.wangyang.bioinfo.web;

import com.wangyang.bioinfo.pojo.LoginUser;
import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.pojo.UserParam;
import com.wangyang.bioinfo.pojo.dto.UserDto;
import com.wangyang.bioinfo.service.IUserService;
import com.wangyang.bioinfo.util.Token;
import com.wangyang.bioinfo.util.TokenProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    TokenProvider tokenProvider;


    @GetMapping
    public Page<User> page(@PageableDefault(sort = {"id"},direction = DESC) Pageable pageable){
        return userService.pageUser(pageable);
    }

    @GetMapping("/listAll")
    public List<UserDto> listAll(){
        return userService.listAll();
    }



    @PostMapping("/login")
    public LoginUser login(@RequestBody UserParam inputUser){
        User user = userService.login(inputUser.getUsername(), inputUser.getPassword());
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user,loginUser);
        Token token = tokenProvider.generateToken(user);
        loginUser.setToken(token.getToken());
        return loginUser;
    }
}
