package com.yh.swaggerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: swagger-pro
 * @Date: 2021/6/27 11:45
 * @Author: YH
 * @Description:
 */
@Data
public class Upload implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer mpId;

    private String filename;

    @ApiModelProperty(required = true,example = "1997-01-01 00:00:00",value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatime;

    @ApiModelProperty(required = true,example = "1997-01-01 00:00:00",value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;
}
