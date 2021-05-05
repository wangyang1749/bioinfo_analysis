package com.wangyang.bioinfo.repository;

import com.wangyang.bioinfo.pojo.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface ResourceRepository extends JpaRepository<Resource,Integer> {
}
