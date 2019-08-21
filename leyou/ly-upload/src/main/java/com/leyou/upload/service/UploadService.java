package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author coderHuang
 * @date 2019/8/13 16:47
 * @github https://github.com/CodeHuang
 */
@Service
@Slf4j
public class UploadService {
    @Autowired
    private FastFileStorageClient client;
    private static final List<String> allowTypes = Arrays.asList("image/jpeg","image/png","image/jpg","image/bmp");
    public String uploadImage(MultipartFile file) {
        //校验文件类型
        String contentType = file.getContentType();
        if(!allowTypes.contains(contentType)){
            throw new LyException(ExceptionEunm.FILE_TYPE_ERROR);
        }
        //校验文件内容
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image==null){
                throw new LyException(ExceptionEunm.IMAGE_FILE_NOTE_FOUND);
            }
        } catch (IOException e) {
            throw new LyException(ExceptionEunm.FILE_TYPE_ERROR);
        }
        /*//准备目标路径
        File dest = new File("D:\\upup",file.getOriginalFilename());*/
        try {
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            System.out.println("----------------------------------------------"+storePath.getFullPath());
            //返回路径
            return "http://image.leyou.com/"+storePath.getFullPath();
            /*file.transferTo(dest);*/
        } catch (IOException e) {
            log.error("上传文件失败",e);
            throw new LyException(ExceptionEunm.UPLOAD_FILE_ERROR);
        }

    }
}
