package com.yh.swaggerpro.controller;

import com.yh.swaggerpro.entity.JobUser;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.JobUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: swagger-pro
 * @Date: 2021/6/17 22:07
 * @Author: YH
 * @Description:
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private JobUserService jobUserService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录方法")
    public DataResponse<JobUser> login(@Validated @RequestParam String jobCode, @RequestParam String password, HttpSession httpSession){
        return jobUserService.queryLogin(jobCode,password,httpSession);
    }




}
