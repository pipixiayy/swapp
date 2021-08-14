package com.yh.swaggerpro.config;

import com.yh.swaggerpro.entity.JdComputer;
import com.yh.swaggerpro.mapper.JdComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: swagger-pro
 * @Date: 2021/7/15 21:37
 * @Author: YH
 * @Description:
 */
@Component
public class ThreadTest {

    @Autowired
    private JdComputerMapper jdComputerMapper;

    @Async(value = "taskScheduler")
    public void updateDateAll(List<JdComputer> list){

        for (JdComputer jd : list) {
                jd.setName(jd.getName() + "***ttt" + Thread.currentThread().getId());
                jd.setCode(jd.getCode() + "***ttt" + Thread.currentThread().getId());
                jdComputerMapper.updateById(jd);
            }
    }
}
