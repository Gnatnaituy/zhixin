package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.Banner;
import com.zhixin.mapper.BannerMapper;
import com.zhixin.service.BannerService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestBannerSaveVo;
import com.zhixin.vo.response.ResponseBannerVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    private final BannerMapper bannerMapper;

    public BannerServiceImpl(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestBannerSaveVo> saveVos) {
        if (ObjectUtils.isEmpty(saveVos)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        List<Banner> updates = saveVos.stream()
                .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                .map(o -> {
                    Banner banner = new Banner();
                    banner.setId(o.getId());
                    banner.setImage(o.getImage());
                    banner.setSort(o.getSort());
                    return banner;
                })
                .collect(Collectors.toList());
        List<Long> retainedIds = saveVos.stream()
                .map(RequestBannerSaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());
        List<Banner> adds = saveVos.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .map(o -> {
                    Banner banner = new Banner();
                    banner.setId(o.getId());
                    banner.setImage(o.getImage());
                    banner.setSort(o.getSort());
                    return banner;
                })
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(retainedIds)) {
            this.remove(new QueryWrapper<>());
        } else {
            QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
            queryWrapper.notIn(Banner.ID, retainedIds);
            this.remove(queryWrapper);
        }
        if (!ObjectUtils.isEmpty(updates)) {
            this.updateBatchById(updates, updates.size());
        }
        if (!ObjectUtils.isEmpty(adds)) {
            this.saveBatch(adds);
        }

        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity listAll() {
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(Banner.SORT);
        List<Banner> banners = bannerMapper.selectList(queryWrapper);
        if (ObjectUtils.isEmpty(banners)) {
            return ResponseEntity.success(Collections.emptyList());
        }

        List<ResponseBannerVo> bannerVos = banners.stream()
                .map(o -> Convert.convert(ResponseBannerVo.class, o))
                .collect(Collectors.toList());

        return ResponseEntity.success(bannerVos);
    }
}
