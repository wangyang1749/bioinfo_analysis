package com.wangyang.bioinfo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyang
 * @date 2021/4/23
 */
@RestController
@RequestMapping("/api/main")
public class MainController {

    @GetMapping("/test")
    public String test(){
        return "你好";
    }
}
