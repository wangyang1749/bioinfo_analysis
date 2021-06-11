package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.pojo.Resource;
import com.wangyang.bioinfo.service.IResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author wangyang
 * @date 2021/5/5
 */
@Service
public class ResourceServiceImpl implements IResourceService {
    @Override
    public Resource addResource(Resource resource) {
        return null;
    }

    @Override
    public Resource findRoleById(int id) {
        return null;
    }

    @Override
    public Resource delResource(int id) {
        return null;
    }

    @Override
    public Page<Resource> pageResource(Pageable pageable) {
        return null;
    }
}
