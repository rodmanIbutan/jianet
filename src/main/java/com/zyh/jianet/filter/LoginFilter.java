package com.zyh.jianet.filter;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.zyh.jianet.entity.Status;
import com.zyh.jianet.until.JwtUntil;

import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    private final String[] URL = {"/user/login","/img","/card/getById"};
    private final String TOKEN = "token";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer requestUrl = request.getRequestURL();
        String url = requestUrl.toString();
        if ("options".equalsIgnoreCase(request.getMethod())){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        for (String s : URL){
            if (url.contains(s)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        String token = request.getHeader(TOKEN);
        if (token == null){
            error(response,"请先登录");
            return;
        }
        try {
            JwtUntil.parseJWT(token);
            filterChain.doFilter(servletRequest,servletResponse);
        }catch (Exception e){
            error(response, String.valueOf(e));
        }
    }
    private void error(HttpServletResponse response,String message) throws IOException{
        Status status = new Status(false,501,message,null);
        String error = JSONObject.toJSONString(status);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(error);
    }
}
