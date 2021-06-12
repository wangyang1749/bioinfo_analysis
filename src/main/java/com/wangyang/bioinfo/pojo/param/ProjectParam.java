package com.wangyang.bioinfo.pojo.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author wangyang
 * @date 2021/6/12
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectParam {
    @NotBlank(message = "项目名称不能为空!")
    private String name;
    private String description;
    private Date deadline;
}
