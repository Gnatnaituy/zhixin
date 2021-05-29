package com.zhixin.service;

import com.zhixin.vo.request.RequestBannerSaveVo;
import com.zhixin.vo.response.ResponseBannerVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:15
 */
public interface BannerService {

    void save(RequestBannerSaveVo saveVo);

    void delete(Long id);

    List<ResponseBannerVo> list();
}
