package com.zhixin.utils;

import com.zhixin.consts.ErrorMessage;
import com.zhixin.vo.common.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Calendar;
import java.util.UUID;

/**
 * @author yutiantang
 * @create 2021/5/29 23:28
 */
@Slf4j
@Component
public class UploadUtil {

    @Value("${static.resources.path}")
    private String path;

    public ResponseEntity upload(MultipartFile file) {
        if (ObjectUtils.isEmpty(file) || file.isEmpty() || ObjectUtils.isEmpty(file.getOriginalFilename())) {
            return ResponseEntity.error(ErrorMessage.EMPTY_FILE);
        }

        String filePath = path + "images" + File.separator + getYearAndMonth();
        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String originFileName = file.getOriginalFilename();
        String fileName = filePath + getUUID() + "-" + originFileName;
        try (FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
        } catch (IOException e) {
            log.error("上传失败: ", e);
            return ResponseEntity.error(ErrorMessage.UPLOAD_FAILED);
        }

        return ResponseEntity.success(fileName.substring(path.length() - 1));
    }

    private String getYearAndMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        return year + File.separator + month + File.separator;
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
