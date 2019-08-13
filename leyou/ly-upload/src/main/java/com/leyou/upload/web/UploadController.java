package com.leyou.upload.web;

import com.leyou.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file){
        String url = uploadService.uploadImage(file);
        return ResponseEntity.ok(url);
    }
}
