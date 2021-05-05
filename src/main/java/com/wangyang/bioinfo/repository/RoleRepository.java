package com.wangyang.bioinfo.repository;

import com.wangyang.bioinfo.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface RoleRepository extends JpaRepository< Role,Integer> {
}
