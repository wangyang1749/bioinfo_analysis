package com.wangyang.bioinfo.pojo.dto;
import com.wangyang.bioinfo.pojo.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@Data
public class RoleDto {
    private int id;
    private String name;
//    private Set<ResourceDto> resources = new HashSet<>();
//    private Set<User> users = new HashSet<>();
}
