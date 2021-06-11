package com.wangyang.bioinfo.pojo.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@Data
public class ResourceDto {
    private int id;
    private String name;
    private String path;
    private Set<RoleDto> roles = new HashSet<>();
}
