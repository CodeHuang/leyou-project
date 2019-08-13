package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author coderHuang
 * @date 2019/8/13 16:47
 * @github https://github.com/CodeHuang
 */
@Service
@Slf4j
public class UploadService {
    @Autowired

    public String uploadImage(MultipartFile file) {
        //准备目标路径
        File dest = new File("",file.getOriginalFilename());
        //保存文件到本地
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            log.error("上传文件失败",e);
            throw new LyException(ExceptionEunm.UPLOAD_FILE_ERROR);
        }
        //返回路径

        return null;
    }
}
