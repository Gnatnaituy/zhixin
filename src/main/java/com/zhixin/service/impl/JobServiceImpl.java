package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.entity.Job;
import com.zhixin.entity.Module;
import com.zhixin.mapper.JobMapper;
import com.zhixin.service.JobService;
import com.zhixin.vo.common.RequestSearchVo;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestJobSaveVo;
import com.zhixin.vo.response.ResponseJobVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.io.File;

/**
 * @author yutiantang
 * @create 2021/6/13 10:28
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(RequestJobSaveVo saveVo) {
        Job job = Convert.convert(Job.class, saveVo);
        if (ObjectUtils.isEmpty(job.getId())) {
            this.save(job);
        } else {
            this.updateById(job);
        }

        return ResponseEntity.success();
    }

    @Override
    public IPage<ResponseJobVo> listJobs(RequestSearchVo searchVo) {
        if (ObjectUtils.isEmpty(searchVo.getPageStart())) {
            searchVo.setPageStart(0);
        }
        if (ObjectUtils.isEmpty(searchVo.getPageLength())) {
            searchVo.setPageLength(10);
        }

        Page<Job> page = new Page<>(searchVo.getPageStart(), searchVo.getPageLength());

        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(Module.CREATE_TIME);
        Page<Job> jobs = this.page(page, queryWrapper);

        return jobs.convert(o -> Convert.convert(ResponseJobVo.class, o));
    }

    public static void main(String[] args) {
        ZipUtil.unzip(new File("/Users/ravooo/Downloads/esl-client.zip"), new File("/Users/ravooo/Downloads/aaaaa"));
    }
}
