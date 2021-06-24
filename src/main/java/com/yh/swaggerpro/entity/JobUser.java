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
@ApiModel(value="JobUser对象", description="")
public class JobUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String jobName;

    private String jobCode;

    private String password;

    private String address;

    @ApiModelProperty(value = "创建时间",example = "1977-08-08 00:00:00")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "修改时间",example = "1977-08-08 00:00:00")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date lastTime;


}
