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
import org.springframework.util.ResourceUtils;
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
 * @Date: 2021/6/27 8:43
 * @Author: YH
 * @Description:
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${filePath}")
    public String filePath;

    @PostMapping("/file")
    @ApiOperation(value = "上传文件")
        public DataResponse<Upload> upload(HttpServletRequest request, MultipartFile file) throws IOException {

        String path = ResourceUtils.getURL("classpath:test.txt").getPath();

        File fileLocal = new File(path);

        FileInputStream fileInputStream = new FileInputStream(fileLocal);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        BufferedReader in = new BufferedReader(inputStreamReader);

        String fileName = fileLocal.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        String prefix = fileName.substring(fileName.lastIndexOf("."));

        String fileOtherName = fileName.substring(0, fileName.length() - prefix.length());//得到文件名。去掉了后缀

        logger.info("文件名为:{}", fileOtherName);
        logger.info("文件后缀名:{}", suffix);

        FileWriter writer = null;
        String filenameNew = UUID.randomUUID() + "." + suffix;//文件上传后重命名
        String data = "";
        String newDta = "";
        while (((data = in.readLine()) != null)) {
            logger.info("读取文件内容:{}", data);
            List<Upload> uploads = new ArrayList<>();
            String[] mpIdArray = data.split(",");

            for (String mpId : mpIdArray ) {
                Upload upload = new Upload();
                upload.setMpId(Integer.valueOf(mpId));
                upload.setFilename(filenameNew);
                uploads.add(upload);
            }
            newDta = data;
            fileUploadService.insertUpload(uploads);

        }
        File fileTxt = new File(filenameNew);
        System.out.println(newDta);
        // 创建一个file对象，指向其文件
        File fileWrite = new File(filePath);
        if (!fileWrite.exists()) {
            // 创建它所在的文件夹的目录，（该文件夹不存在的话，创建）
            fileWrite.mkdirs();
        }
        fileWrite.createNewFile();
        File checkFile = new File(filePath + "/" + filenameNew);
        if (!checkFile.exists()) {
            checkFile.createNewFile();// 创建目标文件
        }
        writer = new FileWriter(checkFile, true);
        writer.append(newDta);
        writer.flush();
        logger.info("文件写入:{}",checkFile);
        return new DataResponse(StatusCode.fileLoadSuccess);
    }
}
