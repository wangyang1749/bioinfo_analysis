package com.wangyang.bioinfo.repository;

import com.wangyang.bioinfo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface UserRepository extends JpaRepository<User, Integer>
        , JpaSpecificationExecutor<User> {
}
