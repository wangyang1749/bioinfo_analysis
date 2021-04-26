package com.wangyang.bioinfo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Future;

/**
 * @author wangyang
 * @date 2021/4/23
 */
//@RestController
@Controller
@Slf4j
public class MainController {

    @Autowired
    TestAsync testAsync;
    @GetMapping("/test")
    @ResponseBody
    public String test(){


        System.out.println("-----test before");
        testAsync.testAsync();
        System.out.println("-----test after");
        return "你好";
    }

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }

}
