package com.wangyang.bioinfo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyang
 * @date 2021/4/24
 */
public class BioInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        System.out.println(uri);
        if(uri.startsWith("/api")){
            System.out.println("需要授权!");
//            response.getWriter().write("需要授权!!");
            return true;
        }
        return true;
    }

}
