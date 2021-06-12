package com.wangyang.bioinfo.web;

import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.pojo.param.ProjectParam;
import com.wangyang.bioinfo.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.Sort.Direction.DESC;
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
    public Page<Project> page(@PageableDefault(sort = {"id"},direction = DESC) Pageable pageable){
        Page<Project> projects = projectService.pageProject(pageable);
        return projects;
    }
    @PostMapping
    public Project add( @Valid @RequestBody ProjectParam projectParam){
        Project project = new Project();
        BeanUtils.copyProperties(projectParam,project);
        project = projectService.addProject(project);
        return project;
    }
    @PostMapping("/update/{id}")
    public Project update(@PathVariable("id")int id, @Valid @RequestBody ProjectParam projectParam){
        Project project = new Project();
        BeanUtils.copyProperties(projectParam,project);
        project = projectService.updateProject(id,project);
        return project;
    }

    @GetMapping("/find/{id}")
    public Project findProjectById(@PathVariable("id")int id){
        return projectService.findProjectById(id);
    }

}
