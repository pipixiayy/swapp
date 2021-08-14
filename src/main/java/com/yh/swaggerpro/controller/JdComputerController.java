package com.yh.swaggerpro.controller;


import com.yh.swaggerpro.config.ThreadTest;
import com.yh.swaggerpro.emun.StatusCode;
import com.yh.swaggerpro.entity.JdComputer;
import com.yh.swaggerpro.entity.ReqJdcomputer;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.JdComputerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/yh/computer")
public class JdComputerController {

    @Autowired
    private JdComputerService jdComputerService;

    @Autowired
    private ThreadTest threadTest;

    @Value("${test.value}")
    private String value;

    @PostMapping("/getComputerDta")
    @ApiOperation(value = "查询jdCompeter")
    //@OperationAop
    public DataResponse<List<JdComputer>> getComputerDta(@RequestBody JdComputer jdComputer) {
        return jdComputerService.queryComputerList(jdComputer);
    }

    @PostMapping("/getReqJd/{id}")
    @ApiOperation(value = "getReqJd")
    //@OperationAop
    public DataResponse<ReqJdcomputer> getReqJd(@PathVariable("id") @Validated Long id) {
        return jdComputerService.queryReqJd(id);

    }

    @PostMapping("/insertData")
    @ApiOperation(value = "insertData")
    public DataResponse<ReqJdcomputer> insertData(){
        jdComputerService.insertData();
        return new DataResponse(StatusCode.Success);
    }

    @PostMapping("/updateData")
    @ApiOperation(value = "updateData")
    public DataResponse<ReqJdcomputer> updateData(){
        int begin = 0;
        int count = 300;
        while (true) {
            String limit = "limit " + begin * count + "," + count;
            List<JdComputer> list = jdComputerService.queryList(limit);
            begin ++;
            if (list.size() < 1){break;}
            threadTest.updateDateAll(list);

        }
        return new DataResponse(StatusCode.Success);
    }

    @PostMapping("/test")
    @ApiOperation(value = "test")
    public String test(){
        return value;
    }
}
