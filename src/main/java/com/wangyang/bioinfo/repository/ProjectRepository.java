package com.wangyang.bioinfo.repository;

import com.wangyang.bioinfo.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangyang
 * @date 2021/6/12
 */
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
