package com.yh.swaggerpro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yh.swaggerpro.entity.Upload;
import com.yh.swaggerpro.mapper.FileUploadMapper;
import com.yh.swaggerpro.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: swagger-pro
 * @Date: 2021/6/27 11:42
 * @Author: YH
 * @Description:
 */
@Service
public class FileUploadServiceImpl  extends ServiceImpl<FileUploadMapper, Upload> implements FileUploadService {

    private static Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Autowired
    private FileUploadMapper fileUploadMapper;

    @Override
    public void insertUpload(List<Upload> upload) {

        try {
            fileUploadMapper.batchInsert(upload);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存数据异常:{}",e.getMessage());
        }
    }

}
