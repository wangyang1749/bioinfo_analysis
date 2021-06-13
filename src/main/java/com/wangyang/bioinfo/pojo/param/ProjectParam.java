package com.wangyang.bioinfo.pojo.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wangyang.bioinfo.config.JsonDateDeserializer;
import com.wangyang.bioinfo.pojo.ProjectStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    /**
     * 将Json反序列化成日期时会按照yyyy-MM-dd HH:mm指定的日期格式进行解析，
     * 若日期字符串的格式不满足以上指定的格式将会直接报错
     */
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date deadline;
    private String jupyterUrl;
    ProjectStatus projectStatus;
}
