package com.zyh.jianet.filter;

import com.alibaba.fastjson.JSONObject;
import com.zyh.jianet.entity.Status;
import com.zyh.jianet.mapper.UserMapper;
import com.zyh.jianet.until.JwtUntil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    private final String[] URL = {"/user/login","/img"};
    private final String TOKEN = "token";
    final UserMapper userMapper;
    public LoginFilter(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
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
            error(response,"无token，请先登录",501);
            return;
        }
        try {
            // TODO: 2023/10/25 请求头token验证是否过期
            String userNumber = JwtUntil.parseJWT(token).get("number",String.class);
            String userToken = userMapper.selectUserByNumber(userNumber).getToken();
            if (!token.equals(userToken)){
                error(response,"登录过期，请重新登录",502);
            }else{
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }catch (Exception e){
            error(response, "token错误",502);
        }
    }
    private void error(HttpServletResponse response,String message,int code) throws IOException{
        Status<Object> status = new Status<>(false,code,message,null);
        String error = JSONObject.toJSONString(status);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(error);
    }
}
