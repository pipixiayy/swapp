package com.yh.swaggerpro.controller;


import com.yh.swaggerpro.entity.JdComputer;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.JdComputerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("computer")
public class JdComputerController {

    @Autowired
    private JdComputerService jdComputerService;

    @PostMapping("/getComputerDta")
    @ApiOperation(value = "查询jdCompeter")
    public DataResponse<List<JdComputer>> getComputerDta(@RequestBody JdComputer jdComputer) {
        return jdComputerService.queryComputerList(jdComputer);
    }


}
