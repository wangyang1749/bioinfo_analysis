package com.wangyang.bioinfo.pojo.dto;

import com.wangyang.bioinfo.pojo.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@Data
public class UserDto {
    private int id;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private int gender;
    private Set<Role> roles =new HashSet<>();
}
