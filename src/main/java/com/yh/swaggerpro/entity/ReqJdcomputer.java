package com.yh.swaggerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: swagger-pro
 * @Date: 2021/7/8 22:01
 * @Author: YH
 * @Description:
 */
@Data
public class ReqJdcomputer {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;
}
