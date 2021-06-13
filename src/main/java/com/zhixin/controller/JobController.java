package com.zhixin.controller;

import com.zhixin.service.JobService;
import com.zhixin.vo.common.RequestSearchVo;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestJobSaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yutiantang
 * @create 2021/6/13 10:29
 */
@Api
@RestController
@RequestMapping(value = "/contact")
public class JobController {

    @Autowired
    private JobService jobService;

    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody RequestJobSaveVo saveVo) {
        return jobService.save(saveVo);
    }

    @ApiOperation(value = "xxx")
    @PostMapping(value = "/list")
    public ResponseEntity list(@RequestBody RequestSearchVo searchVo) {
        return ResponseEntity.success(jobService.listJobs(searchVo));
    }
}
