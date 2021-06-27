package com.yh.swaggerpro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.swaggerpro.entity.Upload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: swagger-pro
 * @Date: 2021/6/27 11:47
 * @Author: YH
 * @Description:
 */
public interface FileUploadMapper extends BaseMapper<Upload> {

    void batchInsert(@Param("list") List<Upload> list);
}
