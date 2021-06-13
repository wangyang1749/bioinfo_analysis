package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.pojo.vo.ProjectListVo;
import com.wangyang.bioinfo.pojo.vo.ProjectVo;
import com.wangyang.bioinfo.repository.ProjectRepository;
import com.wangyang.bioinfo.service.IProjectService;
import com.wangyang.bioinfo.service.IUserService;
import com.wangyang.bioinfo.util.BioinfoException;
import com.wangyang.bioinfo.util.ServiceUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/6/12
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    IUserService userService;

    @Override
    public Project addProject(Project inputProject) {
        Project project = projectRepository.save(inputProject);
        return project;
    }

    @Override
    public Project delProject(int id,int userId) {
        Project project = findProjectById(id);
        if(project.getUserId()!=userId){
            throw new BioinfoException("该项目不是由您创建不能删除！");
        }
        projectRepository.deleteById(id);
        return project;
    }

    @Override
    public Project findProjectById(int id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if(!projectOptional.isPresent()){
            throw new BioinfoException("要操作的Project不存在！");
        }
        Project project = projectOptional.get();
        return project;
    }

    @Override
    public Page<Project> pageProject(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects;
    }

    @Override
    public Project updateProject(int id,Project updateProject) {
        Project project = findProjectById(id);
        BeanUtils.copyProperties(updateProject,project,"id","userId");
        projectRepository.save(project);
        return project;
    }


    @Override
    public ProjectVo convertProjectVo(Project project) {
        ProjectVo projectVo = new ProjectVo();
        BeanUtils.copyProperties(project,projectVo);
        User user = userService.findUserById(project.getUserId());
        projectVo.setUser(user);
        return projectVo;
    }

    @Override
    public Page<ProjectListVo> convertProjectListVo(Page<Project> pageProject) {
        List<Project> projects = pageProject.getContent();
        Set<Integer> ids = ServiceUtil.fetchProperty(projects, Project::getUserId);
        List<User> users = userService.findAllById(ids);
        Map<Integer, User> userMap = ServiceUtil.convertToMap(users, User::getId);
        Page<ProjectListVo> projectListVos = pageProject.map(project -> {
            ProjectListVo projectListVo = new ProjectListVo();
            projectListVo.setUser(userMap.get(project.getUserId()));
            BeanUtils.copyProperties(project,projectListVo);
            return projectListVo;
        });
        return projectListVos;
    }
}
