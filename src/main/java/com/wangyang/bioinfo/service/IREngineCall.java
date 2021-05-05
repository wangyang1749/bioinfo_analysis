package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.dto.RBasicGraphics;

import java.io.File;

/**
 * @author wangyang
 * @date 2021/4/26
 */
public interface IREngineCall {
    File basicGraphics(String source, String data);
}
