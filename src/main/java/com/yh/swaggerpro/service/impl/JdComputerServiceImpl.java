package com.yh.swaggerpro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yh.swaggerpro.emun.StatusCode;
import com.yh.swaggerpro.entity.JdComputer;
import com.yh.swaggerpro.entity.ReqJdcomputer;
import com.yh.swaggerpro.mapper.JdComputerMapper;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.JdComputerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public DataResponse<ReqJdcomputer> queryReqJd(Long id) {

        ReqJdcomputer reqJdcomputer = new ReqJdcomputer();

        DataResponse<ReqJdcomputer> dataResponse = null;
        try {
            QueryWrapper<JdComputer> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("id", "code", "name").eq("id",id);
            JdComputer req = jdComputerMapper.selectOne(queryWrapper);

            reqJdcomputer.setId(req.getId());
            reqJdcomputer.setCode(req.getCode());
            reqJdcomputer.setName(req.getName());

            dataResponse = new DataResponse<>(StatusCode.Success);
            dataResponse.setData(reqJdcomputer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }

    @Override
    public void insertData() {

        ArrayList<JdComputer> list = new ArrayList<>();

        for (int i = 0; i < 6000; i++) {
            JdComputer jdComputer = new JdComputer();
            jdComputer.setCode("test" + i);
            jdComputer.setName("name_" + i);
            jdComputer.setMoney(Double.valueOf(i));
            jdComputer.setCreatime(new Date());
            jdComputer.setStatus("1");
            list.add(jdComputer);
        }
        for (JdComputer jd : list) {
            jdComputerMapper.insert(jd);
        }
    }

    @Override
    public List<JdComputer> queryList(String limit) {
        QueryWrapper<JdComputer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status","1").orderByAsc("creatime").last(limit);
        return jdComputerMapper.selectList(queryWrapper);
    }
}
