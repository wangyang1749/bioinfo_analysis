package com.wangyang.bioinfo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangyang
 * @date 2021/4/23
 */
//@RestController
@Controller
public class MainController {

    @GetMapping("/test")
    public String test(){
        return "你好";
    }

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }
}
