package com.yh.swaggerpro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yh.swaggerpro.emun.StatusCode;
import com.yh.swaggerpro.entity.JobUser;
import com.yh.swaggerpro.mapper.JobUserMapper;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.JobUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
@Service
public class JobUserServiceImpl extends ServiceImpl<JobUserMapper, JobUser> implements JobUserService {

    private static Logger logger = LoggerFactory.getLogger(JobUserServiceImpl.class);

    @Override
    public DataResponse<JobUser> queryLogin(String jobCode, String password, HttpSession httpSession) {
        DataResponse<JobUser> response;
        try {
            logger.info("获取用户信息，查询参数:{}",jobCode);
            JobUser jobUser = lambdaQuery().eq(JobUser::getJobCode, jobCode).one();

            if (StringUtils.isEmpty(jobUser)){
                response = new DataResponse(StatusCode.loginFail);
                return response;
            }

            if (!jobUser.getPassword().equals(password)){
                response = new DataResponse(StatusCode.loginFailPassword);
                return response;
            }

            response = new DataResponse(StatusCode.loginSuccess);
            response.setData(jobUser);
            httpSession.setAttribute("user",jobUser);
        } catch (Exception e) {
           logger.error("登录异常，异常信息:{}",e.getMessage());
            response = new DataResponse(StatusCode.LoginError);
        }
        return response;
    }
}
