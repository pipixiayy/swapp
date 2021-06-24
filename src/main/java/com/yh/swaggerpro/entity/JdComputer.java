package com.yh.swaggerpro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="JdComputer对象", description="")
public class JdComputer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String code;

    private Double money;

    private String name;

    private String status;

    @ApiModelProperty(required = true,example = "1997-01-01 00:00:00",value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatime;

    @ApiModelProperty(required = true,example = "1997-01-01 00:00:00",value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;


}
