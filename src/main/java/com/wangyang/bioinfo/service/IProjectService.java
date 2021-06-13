package com.wangyang.bioinfo.service;


import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.pojo.vo.ProjectListVo;
import com.wangyang.bioinfo.pojo.vo.ProjectVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author wangyang
 * @date 2021/6/12
 */
public interface IProjectService {
    Project addProject(Project inputProject);
    Project delProject(int id,int userId);
    Project findProjectById(int id);
    Page<Project> pageProject(Pageable pageable);
    Project updateProject(int id,Project project);
    // ---------------------------------------

    ProjectVo convertProjectVo(Project project);
    Page<ProjectListVo> convertProjectListVo(Page<Project> projects);
}
