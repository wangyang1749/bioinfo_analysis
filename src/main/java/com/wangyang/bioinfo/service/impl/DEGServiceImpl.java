package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.pojo.DEG;
import com.wangyang.bioinfo.repository.DEGRepository;
import com.wangyang.bioinfo.service.IDEGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author wangyang
 * @date 2021/4/24
 */
@Service
public class DEGServiceImpl implements IDEGService {


    @Override
    public Page<DEG> page(Pageable pageable) {

        return null;
    }
}
