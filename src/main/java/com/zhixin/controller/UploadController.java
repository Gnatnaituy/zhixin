package com.zhixin.controller;

import com.zhixin.utils.UploadUtil;
import com.zhixin.vo.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yutiantang
 * @create 2021/5/29 23:30
 */
@Api
@RestController
public class UploadController {

    @Autowired
    private UploadUtil uploadUtil;

    @ApiOperation(value = "xxx")
    @PostMapping(value = "upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) {
        return uploadUtil.upload(file);
    }
}
