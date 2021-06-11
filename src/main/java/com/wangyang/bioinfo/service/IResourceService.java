package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author wangyang
 * @date 2021/5/5
 */
public interface IResourceService {
    Resource addResource(Resource resource);
    Resource findRoleById(int id);
    Resource delResource(int id);
    Page<Resource> pageResource(Pageable pageable);

}
