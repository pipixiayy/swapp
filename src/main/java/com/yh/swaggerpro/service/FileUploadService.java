package com.yh.swaggerpro.service;

import com.yh.swaggerpro.entity.Upload;

import java.util.List;

/**
 * @program: swagger-pro
 * @Date: 2021/6/27 11:42
 * @Author: YH
 * @Description:
 */
public interface FileUploadService {

    void insertUpload(List<Upload> upload);
}
