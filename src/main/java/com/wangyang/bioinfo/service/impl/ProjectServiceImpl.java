package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.repository.ProjectRepository;
import com.wangyang.bioinfo.service.IProjectService;
import com.wangyang.bioinfo.util.BioinfoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wangyang
 * @date 2021/6/12
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project addProject(Project inputProject) {
        Project project = projectRepository.save(inputProject);
        return project;
    }

    @Override
    public Project delProject(int id) {
        Project project = findProjectById(id);
        if(project==null){
            throw new BioinfoException("要删除的Project不存在！");
        }
        return project;
    }

    @Override
    public Project findProjectById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.isPresent()?project.get():null;
    }

    @Override
    public Page<Project> pageProject(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects;
    }

    @Override
    public Project updateProject(int id,Project updateProject) {
        Project project = findProjectById(id);
        if(project==null){
            throw new BioinfoException("要更新的Project不存在！");
        }
        BeanUtils.copyProperties(updateProject,project,"id");
        projectRepository.save(project);
        return project;
    }
}
