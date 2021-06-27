package com.yh.swaggerpro.controller;

import com.yh.swaggerpro.emun.StatusCode;
import com.yh.swaggerpro.entity.Upload;
import com.yh.swaggerpro.reponse.DataResponse;
import com.yh.swaggerpro.service.FileUploadService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: swagger-pro
 * @Date: 2021/6/27 13:06
 * @Author: YH
 * @Description:
 */
@RestController
@RequestMapping("/uploadServer")
public class LoadController {

    private static Logger logger = LoggerFactory.getLogger(LoadController.class);

    public static final String suffix = ".txt";

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${filePath}")
    public String filePath;

    @PostMapping("/file")
    @ApiOperation(value = "上传文件")
    public DataResponse<Upload> upload(HttpServletRequest request, MultipartFile file) {
        //获取上传文件名,包含后缀
        String originalFilename = file.getOriginalFilename();
        //获取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        if (!suffix.equals(substring)) {//只能上传txt文件
            return new DataResponse<>(StatusCode.fileLoadType);
        }
        //保存的文件名
        String dFileName = UUID.randomUUID() + substring;
        //生成保存文件
        File uploadFile = new File(filePath + dFileName);
        String data = "";
        try {
            file.transferTo(uploadFile);

            File fileLocal = new File(filePath + dFileName);

            FileInputStream fileInputStream = new FileInputStream(fileLocal);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader in = new BufferedReader(inputStreamReader);

            while ((data = in.readLine()) != null) {
                logger.info("读取文件内容:{}", data);
                List<Upload> uploads = new ArrayList<>();
                String[] mpIdArray = data.split(",");

                for (String mpId : mpIdArray ) {
                    Upload upload = new Upload();
                    upload.setMpId(Integer.valueOf(mpId));
                    upload.setFilename(dFileName);
                    uploads.add(upload);
                }
                fileUploadService.insertUpload(uploads);
            }
        } catch (IOException e) {
            logger.error("上传文件错误:{}", e.getMessage());
            return new DataResponse<>(StatusCode.fileLoadFail);
        }
        logger.info("上传文件成功，保存路径:{}", uploadFile);
        return new DataResponse<>(StatusCode.fileLoadSuccess);
    }
}
