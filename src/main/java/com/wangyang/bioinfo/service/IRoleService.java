package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.Role;
import com.wangyang.bioinfo.pojo.dto.RoleDto;
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
    Page<RoleDto> pageRole(Pageable pageable);
    Role updateRole(Role role);
}
