package com.wangyang.bioinfo.service;


import com.wangyang.bioinfo.pojo.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author wangyang
 * @date 2021/6/12
 */
public interface IProjectService {
    Project addProject(Project inputProject);
    Project delProject(int id);
    Project findProjectById(int id);
    Page<Project> pageProject(Pageable pageable);
    Project updateProject(int id,Project project);
    // ---------------------------------------
}
