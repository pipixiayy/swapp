package com.yh.swaggerpro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yh.swaggerpro.entity.JdComputer;
import com.yh.swaggerpro.entity.ReqJdcomputer;
import com.yh.swaggerpro.reponse.DataResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
public interface JdComputerService extends IService<JdComputer> {
    DataResponse<List<JdComputer>> queryComputerList(JdComputer jdComputer);

    DataResponse<ReqJdcomputer> queryReqJd (Long id);

    void insertData();
    List<JdComputer> queryList(String limit);
}
