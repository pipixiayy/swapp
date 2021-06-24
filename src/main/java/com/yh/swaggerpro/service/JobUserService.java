package com.yh.swaggerpro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yh.swaggerpro.entity.JobUser;
import com.yh.swaggerpro.reponse.DataResponse;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
public interface JobUserService extends IService<JobUser> {

    DataResponse<JobUser> queryLogin(String jobCode, String password, HttpSession httpSession);
}
