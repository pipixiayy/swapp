package com.yh.swaggerpro.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yh
 * @since 2021-05-26
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GrantData对象", description="")
public class GrantData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String grantName;

    @ApiModelProperty(required = true,example = "1997-01-01 00:00:00",value = "日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(required = true,example = "1997-01-01 00:00:00",value = "日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;


}
