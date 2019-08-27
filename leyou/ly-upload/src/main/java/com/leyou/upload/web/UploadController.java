package com.leyou.upload.web;

import com.leyou.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片
 * @author coderHuang
 * @date 2019/8/13 16:33
 * @github https://github.com/CodeHuang
 */
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService  uploadService;

    /**
     * 上传图片功能
     * @param file 文件，参数名是file，SpringMVC会封装为一个接口：MultipleFile
     * @return 上传成功后得到的文件的url路径
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file){
        String url = uploadService.uploadImage(file);
        if(StringUtils.isBlank(url)){
            //url为空 上传失败
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //返回200并携带url路径
        return ResponseEntity.ok(url);
    }

    @PostMapping
    public ResponseEntity<String> saveImage(@RequestParam("file")MultipartFile file){
        String url = uploadService.uploadImage(file);
        if(StringUtils.isBlank(url)){
            //url为空 上传失败
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //返回200并携带url路径
        return ResponseEntity.ok(url);
    }
}
