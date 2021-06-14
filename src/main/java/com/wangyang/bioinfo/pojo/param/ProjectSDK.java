package com.wangyang.bioinfo.pojo.param;

import com.wangyang.bioinfo.pojo.enums.ProjectStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wangyang
 * @date 2021/6/14
 */
@Data
public class ProjectSDK {

    private  ProjectStatus projectStatus;
//    private String description;
    @NotBlank(message = "jupyterUrl不能为空!")
    private String jupyterUrl;
}
