package com.yh.swaggerpro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yh.swaggerpro.emun.StatusCode;
import com.yh.swaggerpro.entity.JdComputer;
import com.yh.swaggerpro.mapper.JdComputerMapper;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.JdComputerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
@Service
public class JdComputerServiceImpl extends ServiceImpl<JdComputerMapper, JdComputer> implements JdComputerService {

    public static Logger logger = LoggerFactory.getLogger(JdComputerServiceImpl.class);

    @Autowired
    private JdComputerMapper jdComputerMapper;

    @Override
    public DataResponse<List<JdComputer>> queryComputerList(JdComputer jdComputer) {
        LambdaQueryWrapper<JdComputer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(JdComputer::getId, jdComputer.getId());
        List<JdComputer> jdComputerList = jdComputerMapper.selectList(queryWrapper);

        DataResponse<List<JdComputer>> dataResponse = new DataResponse<>(StatusCode.Success);
        dataResponse.setData(jdComputerList);

        return dataResponse;
    }
}
