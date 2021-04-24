package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.DEG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author wangyang
 * @date 2021/4/24
 */
public interface IDEGService {
    public Page<DEG> page(Pageable pageable);
}
