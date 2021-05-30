package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.Banner;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestBannerSaveVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:15
 */
public interface BannerService extends IService<Banner> {

    ResponseEntity save(List<RequestBannerSaveVo> saveVos);

    ResponseEntity listAll();
}
