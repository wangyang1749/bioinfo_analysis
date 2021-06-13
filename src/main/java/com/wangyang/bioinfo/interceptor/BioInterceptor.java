package com.wangyang.bioinfo.interceptor;

import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.util.AuthorizationException;
import com.wangyang.bioinfo.util.BioinfoException;
import com.wangyang.bioinfo.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyang
 * @date 2021/4/24
 */
public class BioInterceptor implements HandlerInterceptor {

    @Autowired
    TokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod().toString()))return true;
        String uri = request.getRequestURI();
        System.out.println(uri);
//        if(uri.equals("/api/user/login")){
//            return true;
//        }
        if(uri.startsWith("/api")){
            System.out.println("需要授权!");
            String token = getToken(request, "Authorization");
            if(token==null){
                throw new AuthorizationException("未授权！");
            }
            if(!tokenProvider.validateToken(token)){
                throw new AuthorizationException("未授权！");
            }
            User user = tokenProvider.getAuthentication(token);
//            System.out.println(user);
            request.setAttribute("user",user);
        }
        return true;
    }

    public static  String getToken(HttpServletRequest request,String tokenName){
        String bearerToken = request.getHeader(tokenName);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
