package com.yh.swaggerpro.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: swagger-pro
 * @Date: 2021/5/20 20:39
 * @Author: YH
 * @Description:
 */
@RestController
public class SwaggerController {

    @ApiOperation(value = "描述",notes = "描述")
    @RequestMapping(value = "/SwaggerTTT")
    public Map<String, Object> Swagger(){
        Map<String, Object> map = new HashMap<>();
        map.put("result", "返回消息测试");
        return map;
    }
}
