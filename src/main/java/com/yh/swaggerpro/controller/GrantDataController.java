package com.yh.swaggerpro.controller;


import com.yh.swaggerpro.service.GrantDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
@RestController
public class GrantDataController {

    @Autowired
    GrantDataService grantDataService;


}
