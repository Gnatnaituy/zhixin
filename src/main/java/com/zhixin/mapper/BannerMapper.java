package com.zhixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixin.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author yutiantang
 * @create 2021/5/28 23:15
 */
@Mapper
@Component
public interface BannerMapper extends BaseMapper<Banner> {
}
