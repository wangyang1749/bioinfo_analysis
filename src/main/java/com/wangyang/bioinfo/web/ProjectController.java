package com.wangyang.bioinfo.web;

import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.pojo.param.ProjectParam;
import com.wangyang.bioinfo.pojo.vo.ProjectListVo;
import com.wangyang.bioinfo.pojo.vo.ProjectVo;
import com.wangyang.bioinfo.service.IProjectService;
import com.wangyang.bioinfo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.Sort.Direction.DESC;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
/**
 * @author wangyang
 * @date 2021/6/12
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    IProjectService projectService;



    @GetMapping
    public Page<ProjectListVo> page(@PageableDefault(sort = {"id"},direction = DESC) Pageable pageable){
        Page<Project> projects = projectService.pageProject(pageable);
        return projectService.convertProjectListVo(projects);
    }
    @PostMapping
    public Project add( @Valid @RequestBody ProjectParam projectParam,HttpServletRequest request){
        Project project = new Project();
        BeanUtils.copyProperties(projectParam,project);
        User user = (User) request.getAttribute("user");
        project.setUserId(user.getId());
        project = projectService.addProject(project);
        return project;
    }
    @PostMapping("/update/{id}")
    public Project update(@PathVariable("id")int id, @Valid @RequestBody ProjectParam projectParam, HttpServletRequest request){
        Project project = new Project();
        BeanUtils.copyProperties(projectParam,project);
        project = projectService.updateProject(id,project);
        return project;
    }

    @GetMapping("/find/{id}")
    public ProjectVo findProjectById(@PathVariable("id")int id){
        Project project = projectService.findProjectById(id);
        return projectService.convertProjectVo(project);
    }
    @GetMapping("/del/{id}")
    public Project delProject(@PathVariable("id")int id,HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        return projectService.delProject(id,user);
    }
}
