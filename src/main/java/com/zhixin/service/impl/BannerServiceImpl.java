package com.zhixin.service.impl;

import com.zhixin.mapper.BannerMapper;
import com.zhixin.service.BannerService;
import com.zhixin.vo.request.RequestBannerSaveVo;
import com.zhixin.vo.response.ResponseBannerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public void save(RequestBannerSaveVo saveVo) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ResponseBannerVo> list() {
        return null;
    }
}
