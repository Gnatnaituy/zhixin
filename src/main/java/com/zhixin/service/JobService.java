package com.zhixin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.Job;
import com.zhixin.vo.common.RequestSearchVo;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestJobSaveVo;
import com.zhixin.vo.response.ResponseJobVo;

/**
 * @author yutiantang
 * @create 2021/6/13 10:27
 */
public interface JobService extends IService<Job> {

    ResponseEntity save(RequestJobSaveVo saveVo);

    IPage<ResponseJobVo> listJobs(RequestSearchVo searchVo);
}
