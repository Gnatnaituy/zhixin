package com.zhixin.mapper;

import com.zhixin.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yutiantang
 * @create 2021/5/28 23:15
 */
@Mapper
@Component
public interface BannerMapper {

    int save(@RequestParam("banner") Banner banner);

    int update(@RequestParam("banner") Banner banner);

    int delete(@RequestParam("id") Long id);
}
