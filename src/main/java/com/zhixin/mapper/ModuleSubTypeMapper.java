package com.zhixin.mapper;

import com.zhixin.entity.ModuleSubType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ModuleSubTypeMapper {

    int save(@RequestParam("moduleSubType") ModuleSubType moduleSubType);

    int update(@RequestParam("moduleSubType") ModuleSubType moduleSubType);

    int delete(@RequestParam("id") Long id);
}
