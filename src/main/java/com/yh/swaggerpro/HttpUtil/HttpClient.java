package com.yh.swaggerpro.HttpUtil;

import org.springframework.util.StreamUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @program: swagger-pro
 * @Date: 2021/5/22 17:26
 * @Author: YH
 * @Description:
 */
public class HttpClient {
    public static String sendHttpRequest(String HttpUrl, Map<String,String> params) throws Exception{

        //定义访问地址
        URL url = new URL(HttpUrl);

        //连接URL
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        //请求方式
        connection.setRequestMethod("POST");

        //携带参数
        connection.setDoOutput(true);

        StringBuffer sb = new StringBuffer();

        //拼接参数
        for (Map.Entry<String,String> param : params.entrySet()) {
            sb.append("&").append(param.getKey()).append("=").append(param.getValue());
        }

        //去除第一个 & 符，输出参数
        connection.getOutputStream().write(sb.substring(1).getBytes("UTF-8"));

        //连接
        connection.connect();

        //获取返回值
        String response = StreamUtils.copyToString(connection.getInputStream(), Charset.forName("UTF-8"));

        return response;
    }
}
