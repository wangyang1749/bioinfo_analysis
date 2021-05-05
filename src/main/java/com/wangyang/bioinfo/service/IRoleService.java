package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface IRoleService {
    Role addRole(Role role);
    Role findRoleById(int id);
    Role delRole(int id);
    Page<Role> pageRole(Pageable pageable);
}
