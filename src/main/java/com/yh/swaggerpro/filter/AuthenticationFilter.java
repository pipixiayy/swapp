package com.yh.swaggerpro.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yh.swaggerpro.reponse.DataResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: swagger-pro
 * @Date: 2021/8/14 10:00
 * @Author: YH
 * @Description:
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/yh/*"})
public class AuthenticationFilter implements Filter {
    //校验请求地址
    public List<String> ignoreUrl
            = Arrays.asList(
            "/swagger/yh/computer/getComputerDta",
            "/swagger/yh/computer/getReqJd");
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //获取请求URI
        String requestURI = httpRequest.getRequestURI();
        if (!ignoreUrl.contains(requestURI)) {
            //放行
            chain.doFilter(httpRequest, httpResponse);
        } else {
            RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
            String body = requestWrapper.getBody();
            Map<String, String> map = JSON.parseObject(body, new TypeReference<Map<String, String>>() {
            });
            String id = map.get("id");
            if (id.equals("133202")) {
                DataResponse dataResponse = new DataResponse();
                dataResponse.setMsg("非法操作");
                dataResponse.setCode("-1");
                httpResponse.setContentType("application/json; charset=UTF-8");
                httpResponse.getWriter()
                        .write(JSONObject.toJSONString(dataResponse));
            } else {
                chain.doFilter(requestWrapper, response);
            }
        }
    }

    @Override
    public void destroy() { }
}
